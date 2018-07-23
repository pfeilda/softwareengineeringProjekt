package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.equipment.SubstanceContainer;

import javax.swing.JButton;

public class AssayActionAbstract extends JButton {
    protected final SubstanceContainer substanceContainer;

    public AssayActionAbstract(final SubstanceContainer substanceContainer) {
        this.substanceContainer = substanceContainer;
    }
}
