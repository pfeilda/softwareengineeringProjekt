package com.pfeilda.ajb.gui.Elements.Labels;

import com.pfeilda.ajb.miscellaneous.Property;

import javax.swing.JLabel;
import java.awt.Dimension;

public abstract class PropertyLabel extends JLabel {
    public PropertyLabel() {
        this.setMinimumSize(new Dimension(60, 30));
        this.setPreferredSize(new Dimension(60, 30));
        this.setMaximumSize(new Dimension(60, 30));
    }

    public abstract void change(Property property);
}
