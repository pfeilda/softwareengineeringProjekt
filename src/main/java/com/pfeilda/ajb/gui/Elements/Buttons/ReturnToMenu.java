package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.gui.ViewContainer;
import com.pfeilda.ajb.gui.Views.MainMenu;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class ReturnToMenu extends JButton {
    private final ViewContainer parent;

    public ReturnToMenu(final ViewContainer parent) {
        super("Zurück zum Menü");

        this.parent = parent;
        this.addActionListener((ActionEvent action) -> {
            Arrays.stream(parent.getContentPane().getComponents())
                    .forEach(parent::remove);

            parent.add(new MainMenu(parent));

            parent.revalidate();
        });
    }
}
