package com.pfeilda.ajb.gui;

import com.pfeilda.ajb.gui.Views.MainMenu;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.HeadlessException;

public class AJB extends JFrame {
    public AJB() throws HeadlessException {
        super("AJB");
    }

    public void start() {
        final MainMenu mainMenu = new MainMenu(this);
        this.add(mainMenu);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
