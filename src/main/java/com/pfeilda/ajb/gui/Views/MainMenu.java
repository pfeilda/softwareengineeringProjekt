package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.gui.ViewContainer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

public class MainMenu extends View {
    private JButton highScoreViewButton;
    private JButton startGameViewButton;
    private JLabel menuDescription;
    private final ViewContainer parent;

    public MainMenu(final ViewContainer parent) throws HeadlessException {
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
            this.parent.changeView(new StartGameView(this.parent));
        });

        this.highScoreViewButton = new JButton("HighScores anzeigen");
        this.highScoreViewButton.addActionListener((ActionEvent e) -> {
            this.parent.changeView(new HighScoreView(this.parent));
        });
    }

    private void addComponents() {
        this.add(new JLabel("test"));
        this.add(this.menuDescription);
        this.add(this.startGameViewButton);
        this.add(this.highScoreViewButton);
    }
}
