package com.pfeilda.ajb.gui;

import com.pfeilda.ajb.gui.Views.View;

import javax.swing.JFrame;
import java.awt.HeadlessException;

public abstract class ViewContainerAbstract extends JFrame {
    public ViewContainerAbstract(final String title) throws HeadlessException {
        super(title);
    }

    public abstract void changeView(View newView);
}
