package com.pfeilda.ajb.gui.Elements.Menu;

import com.pfeilda.ajb.gui.Elements.Dialog.HelpDialog;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DefaultMenu extends JMenuBar {
    public DefaultMenu() {
        final JMenu help = new JMenu("Hilfe");

        final JMenuItem jMenuItem = new JMenuItem("open");

        help.add(jMenuItem);

        jMenuItem.addActionListener(actionEvent -> {
            new HelpDialog();
        });

        this.add(help);
    }
}
