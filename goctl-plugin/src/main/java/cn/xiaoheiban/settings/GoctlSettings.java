package cn.xiaoheiban.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Application-level persistent settings for the Goctl plugin.
 * Stored in goctl-plugin.xml inside the IDE config directory.
 */
@State(name = "GoctlSettings", storages = @Storage("goctl-plugin.xml"))
@Service(Service.Level.APP)
public final class GoctlSettings implements PersistentStateComponent<GoctlSettings> {

    // ── goctl binary ───────────────────────────────────────────────────────
    /** Absolute path to the goctl binary. Empty = auto-detect from PATH. */
    public String goctlPath = "";

    // ── naming / style ─────────────────────────────────────────────────────
    /** File naming style passed to --style, e.g. "gozero", "goZero", "go_zero". */
    public String style = "gozero";

    // ── template source ────────────────────────────────────────────────────
    /** Where templates come from: "local", "git", or "default" (built-in). */
    public String templateSource = "default";

    /** Absolute path to local home dir (--home). Used when templateSource = "local". */
    public String localTemplateDir = "";

    /** Git remote URL (--remote). Used when templateSource = "git". */
    public String gitRemote = "";

    /** Git branch (--branch). Used when templateSource = "git". */
    public String gitBranch = "";

    // ──────────────────────────────────────────────────────────────────────

    public static GoctlSettings getInstance() {
        return ApplicationManager.getApplication().getService(GoctlSettings.class);
    }

    @Override
    public @Nullable GoctlSettings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull GoctlSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
