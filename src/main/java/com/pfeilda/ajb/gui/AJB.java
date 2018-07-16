package com.pfeilda.ajb.gui;

import com.pfeilda.ajb.gui.Views.MainMenu;
import com.pfeilda.ajb.gui.Views.View;

import javax.swing.WindowConstants;
import java.awt.HeadlessException;

public class AJB extends ViewContainerAbstract {
    public AJB() throws HeadlessException {
        super("AJB");
    }

    public void start() {
        final MainMenu mainMenu = new MainMenu(this);
        this.changeView(mainMenu);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void changeView(final View newView) {
        this.getContentPane().removeAll();

        this.add(newView);
        this.pack();
        this.repaint();
    }
}
