package com.pfeilda.ajb.gui.Elements.Labels;

import com.pfeilda.ajb.miscellaneous.Property;

public class VolumeLabel extends PropertyLabel {
    @Override
    public void change(final Property property) {
        this.setText(property.get() + "");
    }
}
