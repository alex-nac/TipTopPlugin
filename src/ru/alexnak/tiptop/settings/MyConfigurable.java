package ru.alexnak.tiptop.settings;

import com.intellij.openapi.options.BaseConfigurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.alexnak.tiptop.TipTopSettingsForm;

import javax.swing.*;

public class MyConfigurable extends BaseConfigurable implements SearchableConfigurable {
    private TipTopSettingsForm form;
    private ApplicationSettingsComponent stateComponent;

    public MyConfigurable(ApplicationSettingsComponent stateComponent) {
        this.stateComponent = stateComponent;
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "TipTop";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (form == null) {
            form = new TipTopSettingsForm();
        }
        return form.$$$getRootComponent$$$();
    }

    @Override
    public void apply() throws ConfigurationException {
        if (form != null) {
            stateComponent.setState(form.exportDisplayedSettings());
        }
    }

    @Override
    public void reset() {
        if (form != null) {
            form.importFrom(stateComponent.getState());
        }
    }

    @NotNull
    @Override
    public String getId() {
        return "TipTopConfigurable";
    }
}
