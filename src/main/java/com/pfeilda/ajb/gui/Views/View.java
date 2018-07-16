package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.gui.InitialInterface;
import com.pfeilda.ajb.gui.ViewContainerAbstract;

import javax.swing.JPanel;

public abstract class View extends JPanel implements InitialInterface {
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
}
