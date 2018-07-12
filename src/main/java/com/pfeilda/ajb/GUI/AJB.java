package com.pfeilda.ajb.GUI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AJB {
    public void start() {
        final Menu menu = new Menu();
        menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
        menu.add(new JLabel("Bitte wählen sie eine Aktion aus:"));
        menu.add(new JButton("Highscores anzeigen"));
        menu.add(new JButton("Neues Spiel starten"));
    }
}
