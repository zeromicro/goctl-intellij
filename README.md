# Goctl Plugin for JetBrains IDEs

[![JetBrains Marketplace](https://img.shields.io/jetbrains/plugin/v/cn.xiaoheiban.go-zero.svg?label=Marketplace)](https://plugins.jetbrains.com/plugin/cn.xiaoheiban.go-zero)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/cn.xiaoheiban.go-zero.svg)](https://plugins.jetbrains.com/plugin/cn.xiaoheiban.go-zero)
[![License](https://img.shields.io/github/license/zeromicro/goctl-intellij)](LICENSE)

[中文文档](./README_CN.md)

---

## Overview

**Goctl** is a JetBrains IDE plugin that brings first-class support for [go-zero](https://go-zero.dev/) development.
It provides a full-featured editing experience for `.api` files and integrates the `goctl` command-line tool
directly into your IDE workflow — generating Go HTTP services, gRPC/RPC services, and database model code
without ever leaving the editor.

> **go-zero** is a web and RPC framework for Go with many engineering best practices built in. It is designed for
> high-traffic, resilient services and has been running production sites with tens of millions of users.

---

## Features

### 1. API Language Support (`.api` files)

The plugin registers the **Api** language and provides a complete editing experience:

| Feature | Description |
|---|---|
| **Syntax highlighting** | Keywords, types, HTTP methods, routes, tags, and comments are each colored distinctly. |
| **Parser & lexer** | A full BNF grammar parses `.api` files; syntax errors are detected in real time. |
| **Code formatting** | Reformat `.api` files with the standard IDE shortcut (`Reformat Code`). |
| **Code folding** | Fold `type(...)` blocks, struct bodies `{ ... }`, `@server(...)` blocks, `info(...)` blocks, and `service { ... }` bodies. |
| **Code commenting** | Toggle line / block comments with the standard IDE shortcut. |
| **Color scheme page** | Customize API language colors under **Settings > Editor > Color Scheme > Api**. |

### 2. Code Intelligence

| Feature | Description |
|---|---|
| **Semantic annotations** | The annotator highlights type declarations, primitive types, user-defined struct references, route request/response body types, and anonymous embedded fields using different colors. |
| **Duplicate detection** | Reports duplicate struct names (across the file and all imported files) and duplicate field names within a struct as errors. |
| **Unresolved type check** | Flags references to types that are not declared anywhere in the current file or its imports. |
| **Import cycle detection** | Detects and reports circular import chains between `.api` files. |
| **Go-to Declaration** | `Cmd/Ctrl+Click` or **Go to Declaration** on a type name jumps to its definition, even across imported `.api` files. |
| **Handler navigation** | `Cmd/Ctrl+Click` on an `@handler` name opens the generated Go function, using the service directory and `group` to distinguish identical names. |
| **Find Usages / References** | Find all usages of a struct type with **Find Usages** (`Alt+F7`). |
| **Keyword completion** | Code completion for API language keywords when typing identifiers. |

### 3. Live Templates

Live templates provide fast boilerplate insertion inside `.api` files:

| Template | Scope | Expands to |
|---|---|---|
| `syntax` | File | `syntax = "v1"` |
| `import` | File | `import "..."` |
| `info` | File | Full `info(...)` block with title, desc, author, email, version |
| `type` | File | `type ( ... )` group block |
| `service` | File | Full `@server(...) service { @handler ... get ... }` skeleton |
| `handler` | Service body | `@handler handlerName` |
| `get` / `post` / `put` / `delete` / `head` / `connect` / `options` / `trace` | Service body | Route declaration for the corresponding HTTP method |
| `@doc` / `doc` | Service body | `@doc "..."` route documentation |
| `json` | Tag literal | `json:"fieldName"` (field name auto-filled using camelCase macro) |
| `xml` | Tag literal | `xml:"fieldName"` |
| `path` | Tag literal | `path:"fieldName"` |
| `form` | Tag literal | `form:"fieldName"` |

### 4. New API File Action

Right-click any directory in the **Project** view and choose **New > New Api File**.
A dialog lets you enter the file name and choose between:
- **Empty file** — a minimal `.api` file with just the `info` block.
- **Full template** — a complete `.api` skeleton with syntax, info, type, and service blocks.

### 5. Code Generation Actions

Right-click a supported file and choose **Generate** from the context menu:

#### Generate Go Code (`goctl api go`)
- Triggered on `.api` files.
- Opens a dialog to configure:
  - **Output directory** — where the generated Go code is written.
  - **Naming style** (`--style`): `gozero`, `goZero`, `go_zero`, `GoZero`, `GOZERO`.
  - **Template source**: built-in, local directory (`--home`), or Git repository (`--remote` + `--branch`).
- Runs `goctl api go --api <file> --dir <dir> [--style ...] [--home/--remote/--branch ...]`.

#### Generate RPC Code (`goctl rpc protoc`)
- Triggered on `.proto` files.
- Opens a dialog to configure:
  - `--go_out` — output directory for generated Go protobuf stubs.
  - `--go-grpc_out` — output directory for gRPC stubs.
  - `--zrpc_out` — output directory for go-zero zRPC service code.
  - **Naming style** and **template source** (same options as above).
- Runs `goctl rpc protoc <file> --proto_path=<dir> --go_out=... --go-grpc_out=... --zrpc_out=... [...]`.

#### Generate Model Code (`goctl model mysql ddl`)
- Triggered on `.sql` files.
- Opens a dialog to configure:
  - **Output directory**.
  - **Database name** (`--database`) — pre-filled from the SQL file name.
  - **Cache** (`--cache`) with optional cache key prefix (`--prefix`).
  - **Ignore columns** (`--ignore-columns`) — comma-separated list (defaults to `create_time,update_time`).
  - **Naming style** and **template source**.
- Runs `goctl model mysql ddl --src <file> --dir <dir> --database <db> [--cache] [--style ...] [...]`.

### 6. Goctl Output Tool Window

All `goctl` command output is streamed in real time to the **Goctl** tool window at the bottom of the IDE.
The console is cleared before each new command and shows the full stdout / stderr of the process.

### 7. Plugin Settings

Configure global defaults under **Settings > Tools > Goctl**:

| Setting | Description |
|---|---|
| **goctl binary** | Path to the `goctl` executable. Auto-detected from `PATH` if left blank. |
| **Naming style** | Default `--style` value used by all code-generation dialogs. |
| **Template source** | Default template source: built-in, local directory, or Git repository. The local path or Git remote URL and branch are persisted here and pre-filled in every generation dialog. |

---

## Requirements

- JetBrains IDE with the **Go** plugin installed (GoLand, IntelliJ IDEA Ultimate, etc.)
- [`goctl`](https://github.com/zeromicro/go-zero) installed and accessible on `PATH` (or configured in settings)
- Go 1.19+

---

## Installation

1. Open your JetBrains IDE.
2. Go to **Settings > Plugins > Marketplace**.
3. Search for **Goctl** and click **Install**.
4. Restart the IDE.

Or install from disk: **Settings > Plugins > ⚙ > Install Plugin from Disk…** and select the downloaded `.zip`.

---

## Project Structure

```
.
├── src/main/java/cn/xiaoheiban/
│   ├── action/                  # New API File, Generate Go/RPC/Model actions
│   ├── execution/               # GoctlExecutor, console tool window
│   ├── psi/                     # PSI element types and utilities
│   ├── settings/                # Settings, code-gen dialogs
│   ├── template/                # Live template context types and macros
│   ├── Api.bnf                  # Grammar Kit BNF grammar
│   ├── Api.flex                 # JFlex lexer definition
│   ├── ApiAnnotator.java        # Semantic annotations & error checks
│   ├── ApiCompletionContributor.java
│   ├── ApiFoldingBuilder.java
│   ├── ApiFormattingModelBuilder.java
│   └── ApiSyntaxHighlighter.java
└── src/main/resources/
    ├── META-INF/plugin.xml      # Plugin descriptor
    ├── liveTemplates/           # Live template XML definitions
    ├── fileTemplates/internal/  # New API file templates
    └── icons/                   # Plugin icons
```

---

## Useful Links

- [go-zero documentation](https://go-zero.dev/)
- [goctl reference](https://go-zero.dev/docs/goctl/goctl)
- [JetBrains Marketplace listing](https://plugins.jetbrains.com/plugin/cn.xiaoheiban.go-zero)
- [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij)

---

