package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.gui.ViewContainerAbstract;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

public class MainMenu extends View {
    private JButton highScoreViewButton;
    private JButton startGameViewButton;
    private JLabel menuDescription;

    public MainMenu(final ViewContainerAbstract parent) {
        super(parent, "Hauptmenü");
    }

    protected void generateComponents() {
        this.menuDescription = new JLabel("Bitte wählen sie eine Aktion aus:");

        this.startGameViewButton = new JButton("Neues Spiel starten");
        this.startGameViewButton.addActionListener((ActionEvent e) -> {
            new StartGameView(this.parent);
        });

        this.highScoreViewButton = new JButton("HighScores anzeigen");
        this.highScoreViewButton.addActionListener((ActionEvent e) -> {
            new HighScoreView(this.parent);
        });
    }

    @Override
    protected void addComponents() {
        this.generateComponents();

        this.add(this.menuDescription);
        this.add(this.startGameViewButton);
        this.add(this.highScoreViewButton);
    }

    @Override
    protected void addActionButtons() {
    }

    @Override
    protected void selectLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
