package com.pfeilda.ajb.gui.Elements.Menu;

import com.pfeilda.ajb.gui.Elements.Dialog.HelpDialog;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class DefaultMenu extends JMenuBar {
    public DefaultMenu() {
        final JMenu help = new JMenu("Hilfe");

        help.addActionListener(actionEvent -> {
            new HelpDialog();
        });

        this.add(help);
    }
}
