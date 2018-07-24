package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.miscellaneous.Property;

import javax.swing.BoxLayout;
import java.util.List;

public class Properties extends AbstractPartial {
    private final List<Property> properties;

    public Properties(final List<Property> properties) {
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
