package com.pfeilda.ajb.gui;

import com.pfeilda.ajb.equipment.AlterManager;
import com.pfeilda.ajb.gui.Views.MainMenu;
import com.pfeilda.ajb.gui.Views.View;

import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import java.awt.Dimension;
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

        final JScrollPane jScrollPane = new JScrollPane(newView, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setEnabled(true);
        jScrollPane.setPreferredSize(new Dimension(500, 500));

        this.add(jScrollPane);
        this.pack();
        this.repaint();
    }

    @Override
    protected void startAlterManager() {
        final AlterManager alterManager = AlterManager.getInstance();
        final Thread thread = new Thread(alterManager);
        thread.start();
    }
}
