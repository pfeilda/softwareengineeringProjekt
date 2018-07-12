package com.pfeilda.ajb.GUI;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.HeadlessException;

public class Menu extends JFrame {
    public Menu() throws HeadlessException {
        super("Hauptmenue");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setVisible(true);
    }
}
