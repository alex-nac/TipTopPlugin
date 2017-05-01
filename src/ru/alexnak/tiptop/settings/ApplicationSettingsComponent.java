package ru.alexnak.tiptop.settings;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name="ApplicationSettingComponent", storages={@Storage(file = "$APP_CONFIG$/TipTop.xml", id = "TipTopSettings")})
public class ApplicationSettingsComponent implements ApplicationComponent, PersistentStateComponent<Settings> {
    private Settings tipTopSettings = new Settings();

    @Override
    public void initComponent() {

    }

    @Override
    public void disposeComponent() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "TipTop.Settings";
    }

    @Nullable
    @Override
    public Settings getState() {
        return tipTopSettings;
    }

    @Override
    public void loadState(Settings state) {
        tipTopSettings = state;
    }

    public void setState(Settings state) {
        tipTopSettings = state;
    }
}
