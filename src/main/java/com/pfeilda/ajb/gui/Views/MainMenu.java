package com.pfeilda.ajb.gui.Views;

import javax.swing.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

public class MainMenu extends JPanel {
    private JButton highScoreViewButton;
    private JButton startGameViewButton;
    private JLabel menuDescription;
    private final JFrame parent;

    public MainMenu(final JFrame parent) throws HeadlessException {
        this.parent = parent;

        this.parent.setTitle("Hauptmenue");

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.generateComponents();
        this.addComponents();

        this.setVisible(true);
    }

    private void generateComponents() {
        this.menuDescription = new JLabel("Bitte wählen sie eine Aktion aus:");

        this.startGameViewButton = new JButton("Neues Spiel starten");
        this.startGameViewButton.addActionListener((ActionEvent e) -> {
            this.parent.remove(this);
            new StartGameView(this.parent);
        });

        this.highScoreViewButton = new JButton("HighScores anzeigen");
        this.highScoreViewButton.addActionListener((ActionEvent e) -> {
            this.parent.remove(this);
            new HighScoreView(this.parent);
        });
    }

    private void addComponents() {
        this.add(this.menuDescription);
        this.add(this.startGameViewButton);
        this.add(this.highScoreViewButton);
    }
}
