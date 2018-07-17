package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.gui.ViewContainerAbstract;

import java.awt.BorderLayout;

public class AssayContainer extends View {
    public AssayContainer(final ViewContainerAbstract parent, final String title) {
        super(parent, title);
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addComponents() {

    }

    @Override
    public void addActionButtons() {

    }
}
