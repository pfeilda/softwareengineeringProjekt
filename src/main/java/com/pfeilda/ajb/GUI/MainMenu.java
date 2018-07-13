package com.pfeilda.ajb.gui;

import com.pfeilda.ajb.gui.Views.HighScoreView;
import com.pfeilda.ajb.gui.Views.StartGameView;

import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
    JButton highScoreViewButton;
    JButton startGameViewButton;
    JLabel menuDescription;

    public MainMenu() throws HeadlessException {
        super("Hauptmenue");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final Container contentPane = this.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        this.setSize(new Dimension(500, 500));

        this.generateComponents();
        this.addComponents();

        this.setVisible(true);
    }

    private void generateComponents() {
        final MainMenu mainMenu = this;

        this.menuDescription = new JLabel("Bitte wählen sie eine Aktion aus:");

        this.startGameViewButton = new JButton("Neues Spiel starten");
        this.startGameViewButton.addActionListener((ActionEvent e) -> {
            mainMenu.setVisible(false);
            final StartGameView startGameView = new StartGameView();
            startGameView.setVisible(true);
        });

        this.highScoreViewButton = new JButton("HighScores anzeigen");
        this.highScoreViewButton.addActionListener((ActionEvent e) -> {
            mainMenu.setVisible(false);
            final HighScoreView highScoreView = new HighScoreView();
            highScoreView.setVisible(true);
        });
    }

    private void addComponents() {
        this.add(this.menuDescription);
        this.add(this.startGameViewButton);
        this.add(this.highScoreViewButton);
    }
}
