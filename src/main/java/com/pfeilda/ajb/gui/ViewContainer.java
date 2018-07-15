package com.pfeilda.ajb.gui;

import com.pfeilda.ajb.gui.Views.View;

import javax.swing.JFrame;
import java.awt.HeadlessException;

public abstract class ViewContainer extends JFrame {
    public ViewContainer(final String title) throws HeadlessException {
        super(title);
    }

    public abstract void changeView(View view);
}
