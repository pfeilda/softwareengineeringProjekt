package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.gui.InitialInterface;

import javax.swing.JPanel;

public abstract class AbstractPartial extends JPanel implements InitialInterface {
    protected void initial() {
        this.selectLayout();
        this.addComponents();
        this.addActionButtons();
    }
}
