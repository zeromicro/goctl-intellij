# JetBrains IDE Goctl 插件

[![JetBrains Marketplace](https://img.shields.io/jetbrains/plugin/v/cn.xiaoheiban.go-zero.svg?label=Marketplace)](https://plugins.jetbrains.com/plugin/cn.xiaoheiban.go-zero)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/cn.xiaoheiban.go-zero.svg)](https://plugins.jetbrains.com/plugin/cn.xiaoheiban.go-zero)
[![License](https://img.shields.io/github/license/zeromicro/goctl-intellij)](LICENSE)

[English](./README.md)

---

## 概述

**Goctl** 是一款 JetBrains IDE 插件，为 [go-zero](https://go-zero.dev/) 框架开发提供一流的支持。
插件为 `.api` 文件提供完整的编辑体验，并将 `goctl` 命令行工具直接集成到 IDE 工作流中——
无需离开编辑器即可生成 Go HTTP 服务、gRPC/RPC 服务以及数据库 Model 代码。

> **go-zero** 是一个面向 Go 语言的 Web 与 RPC 框架，内置大量工程实践，
> 专为高并发、高可用服务设计，已在日活过千万的生产系统中稳定运行。

---

## 功能特性

### 1. API 语言支持（`.api` 文件）

插件注册了 **Api** 语言，并提供完整的编辑体验：

| 功能 | 说明 |
|---|---|
| **语法高亮** | 关键字、类型、HTTP 方法、路由、Tag、注释等均以不同颜色区分显示。 |
| **解析器与词法分析器** | 基于完整 BNF 文法解析 `.api` 文件，实时检测语法错误。 |
| **代码格式化** | 通过 IDE 标准快捷键（Reformat Code）格式化 `.api` 文件。 |
| **代码折叠** | 支持折叠 `type(...)` 块、结构体 `{ ... }`、`@server(...)` 块、`info(...)` 块和 `service { ... }` 体。 |
| **代码注释** | 通过 IDE 标准快捷键切换行注释 / 块注释。 |
| **颜色方案页** | 在 **Settings > Editor > Color Scheme > Api** 中自定义 API 语言颜色。 |

### 2. 代码智能

| 功能 | 说明 |
|---|---|
| **语义注解** | 对类型声明、基础类型、自定义结构体引用、路由请求/响应体类型及匿名嵌入字段分别进行高亮标注。 |
| **重复定义检测** | 检测当前文件及所有导入文件中的重复结构体名称，以及结构体内的重复字段名，并标记为错误。 |
| **未解析类型检查** | 标记在当前文件或其导入中未声明的类型引用。 |
| **导入循环检测** | 检测并报告 `.api` 文件之间的循环导入链。 |
| **跳转到声明** | `Cmd/Ctrl+Click` 或 **Go to Declaration** 可跳转到类型定义处，支持跨导入文件跳转。 |
| **Handler 跳转** | 在 `@handler` 名称上使用 `Cmd/Ctrl+Click`，可跳转到生成的 Go 函数，并通过服务目录和 `group` 区分同名函数。 |
| **查找引用** | 通过 **Find Usages**（`Alt+F7`）查找结构体类型的所有使用位置。 |
| **关键字补全** | 在输入标识符时提供 API 语言关键字的代码补全。 |

### 3. Live 模板

Live 模板支持在 `.api` 文件中快速插入样板代码：

| 模板 | 作用域 | 展开内容 |
|---|---|---|
| `syntax` | 文件 | `syntax = "v1"` |
| `import` | 文件 | `import "..."` |
| `info` | 文件 | 包含 title、desc、author、email、version 的完整 `info(...)` 块 |
| `type` | 文件 | `type ( ... )` 类型组块 |
| `service` | 文件 | 完整的 `@server(...) service { @handler ... get ... }` 骨架 |
| `handler` | Service 体 | `@handler handlerName` |
| `get` / `post` / `put` / `delete` / `head` / `connect` / `options` / `trace` | Service 体 | 对应 HTTP 方法的路由声明 |
| `@doc` / `doc` | Service 体 | `@doc "..."` 路由文档注释 |
| `json` | Tag 字面量 | `json:"fieldName"`（字段名通过 camelCase 宏自动填充） |
| `xml` | Tag 字面量 | `xml:"fieldName"` |
| `path` | Tag 字面量 | `path:"fieldName"` |
| `form` | Tag 字面量 | `form:"fieldName"` |

### 4. 新建 API 文件

在 **Project** 视图中右键任意目录，选择 **New > New Api File**。
弹出对话框可输入文件名并选择模板：
- **空文件** — 仅包含 `info` 块的最简 `.api` 文件。
- **完整模板** — 包含 syntax、info、type、service 块的完整 `.api` 骨架。

### 5. 代码生成操作

右键支持的文件，从上下文菜单中选择 **Generate**：

#### 生成 Go 代码（`goctl api go`）
- 在 `.api` 文件上触发。
- 对话框可配置：
  - **输出目录** — 生成的 Go 代码写入位置。
  - **命名风格**（`--style`）：`gozero`、`goZero`、`go_zero`、`GoZero`、`GOZERO`。
  - **模板来源**：内置、本地目录（`--home`）或 Git 仓库（`--remote` + `--branch`，支持动态拉取分支列表）。

#### 生成 RPC 代码（`goctl rpc protoc`）
- 在 `.proto` 文件上触发。
- 对话框可配置：
  - `--go_out` — Go protobuf 存根输出目录。
  - `--go-grpc_out` — gRPC 存根输出目录。
  - `--zrpc_out` — go-zero zRPC 服务代码输出目录。
  - 命名风格与模板来源（同上）。

#### 生成 Model 代码（`goctl model mysql ddl`）
- 在 `.sql` 文件上触发。
- 对话框可配置：
  - **输出目录**。
  - **数据库名**（`--database`）— 自动从 SQL 文件名预填充。
  - **缓存**（`--cache`）及可选的缓存键前缀（`--prefix`）。
  - **忽略字段**（`--ignore-columns`）— 逗号分隔，默认忽略 `create_time,update_time`。
  - 命名风格与模板来源。

### 6. Goctl 输出工具窗口

所有 `goctl` 命令的输出实时流式显示在 IDE 底部的 **Goctl** 工具窗口中。
每次新命令执行前自动清空控制台，完整展示进程的 stdout / stderr。

### 7. 插件设置

在 **Settings > Tools > Goctl** 中配置全局默认值：

| 配置项 | 说明 |
|---|---|
| **goctl 可执行文件路径** | `goctl` 的绝对路径，留空则从 `PATH` 自动检测。 |
| **命名风格** | 所有代码生成对话框的默认 `--style` 值。 |
| **模板来源** | 默认模板来源：内置、本地目录或 Git 仓库。本地路径或 Git 远端 URL 及分支会持久化保存，并预填充到每个生成对话框中。 |

---

## 环境要求

- 安装了 **Go** 插件的 JetBrains IDE（GoLand、IntelliJ IDEA Ultimate 等）
- [`goctl`](https://github.com/zeromicro/go-zero) 已安装并可通过 `PATH` 访问（或在设置中配置路径）
- Go 1.19+

---

## 安装方式

1. 打开 JetBrains IDE。
2. 进入 **Settings > Plugins > Marketplace**。
3. 搜索 **Goctl** 并点击 **Install**。
4. 重启 IDE。

或从本地安装：**Settings > Plugins > ⚙ > Install Plugin from Disk…**，选择下载的 `.zip` 文件。

---

## 相关链接

- [go-zero 官网](https://go-zero.dev/)
- [goctl 参考文档](https://go-zero.dev/docs/goctl/goctl)
- [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/cn.xiaoheiban.go-zero)
- [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij)
