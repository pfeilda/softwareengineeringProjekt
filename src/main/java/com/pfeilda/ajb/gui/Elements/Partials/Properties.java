package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.miscellaneous.Property;

import javax.swing.BoxLayout;
import java.util.Set;

public class Properties extends AbstractPartial {
    private final Set<Property> properties;

    public Properties(final Set<Property> properties) {
        this.properties = properties;
        this.initial();
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public void addComponents() {
        final Properties propertiesPanel = this;
        this.properties.forEach((Property property) -> {
            propertiesPanel.add(property.getPropertyLabel());
        });
    }

    @Override
    public void addActionButtons() {

    }
}
