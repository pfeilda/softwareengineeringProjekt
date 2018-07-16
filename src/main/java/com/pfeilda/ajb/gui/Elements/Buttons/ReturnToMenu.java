package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.gui.ViewContainerAbstract;
import com.pfeilda.ajb.gui.Views.MainMenu;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class ReturnToMenu extends JButton {
    private final ViewContainerAbstract parent;

    public ReturnToMenu(final ViewContainerAbstract parent) {
        super("Zurück zum Menü");

        this.parent = parent;
        this.addActionListener((ActionEvent action) -> {
            parent.changeView(new MainMenu(parent));
        });
    }
}
