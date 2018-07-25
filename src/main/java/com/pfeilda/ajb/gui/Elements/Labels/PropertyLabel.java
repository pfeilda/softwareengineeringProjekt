package com.pfeilda.ajb.gui.Elements.Labels;

import com.pfeilda.ajb.miscellaneous.Property;

import javax.swing.JLabel;
import java.awt.Dimension;

public abstract class PropertyLabel extends JLabel {
    public PropertyLabel() {
        this.setMinimumSize(new Dimension(150, 30));
        this.setPreferredSize(new Dimension(150, 30));
        this.setMaximumSize(new Dimension(150, 30));
    }

    public void change(final Property property) {
        this.setText(property.get() + " " + property.getClass().getSimpleName());
    }
}
