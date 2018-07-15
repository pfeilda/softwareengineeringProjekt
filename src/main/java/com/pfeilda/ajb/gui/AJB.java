package com.pfeilda.ajb.gui;

import com.pfeilda.ajb.gui.Views.MainMenu;
import com.pfeilda.ajb.gui.Views.View;

import javax.swing.WindowConstants;
import java.awt.HeadlessException;

public class AJB extends ViewContainer {
    public AJB() throws HeadlessException {
        super("AJB");
    }

    public void start() {
        final MainMenu mainMenu = new MainMenu(this);
        this.changeView(mainMenu);
//        this.add(mainMenu);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void changeView(final View newView) {
//        Arrays.stream(this.getComponents())
//                .forEach(this::remove);
//        for (final Component component :
//                this.getComponents()) {
//            this.remove(component);
//        }

        this.add(newView);
        this.pack();
        this.repaint();
    }
}
