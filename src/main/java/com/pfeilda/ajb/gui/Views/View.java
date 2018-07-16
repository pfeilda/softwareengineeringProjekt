package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.gui.ViewContainerAbstract;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public abstract class View extends JPanel {
    protected ViewContainerAbstract parent;

    public View(final ViewContainerAbstract parent, final String title) {
        this(parent);
        this.parent.setTitle(title);
    }

    public View(final ViewContainerAbstract parent) {
        this.parent = parent;

        this.selectLayout();
        this.addComponents();
        this.addActionButtons();

        this.parent.changeView(this);
    }

    protected abstract void selectLayout();

    protected abstract void addComponents();

    protected abstract void addActionButtons();
}
