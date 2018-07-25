package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.gui.Elements.Dialog.HelpDialog;
import com.pfeilda.ajb.gui.ViewContainerAbstract;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Arrays;

public class MainMenu extends View {
    private JButton highScoreViewButton;
    private JButton startGameViewButton;
    private JButton helpViewButton;
    private JLabel menuDescription;

    public MainMenu(final ViewContainerAbstract parent) {
        super(parent, "Hauptmenü");
    }

    protected void generateComponents() {
        this.menuDescription = new JLabel("Bitte wählen sie eine Aktion aus:");

        this.startGameViewButton = new JButton("Neues Spiel starten");
        this.startGameViewButton.addActionListener(
                actionEvent -> new StartGameView(this.parent)
        );

        this.highScoreViewButton = new JButton("HighScores anzeigen");
        this.highScoreViewButton.addActionListener(
                actionEvent -> new HighScoreView(this.parent)
        );

        this.helpViewButton = new JButton("Hilfe anzeigen");
        this.helpViewButton.addActionListener(
                actionEvent -> new HelpDialog()
        );
    }

    @Override
    public void addComponents() {
        this.generateComponents();

        this.add(this.menuDescription);
        this.add(this.startGameViewButton);
        this.add(this.highScoreViewButton);
        this.add(this.helpViewButton);

        Arrays.stream(this.getComponents()).forEach(
                (Component component) -> ((JComponent) component).setAlignmentX(Component.CENTER_ALIGNMENT)
        );
    }

    @Override
    public void addActionButtons() {
    }

    @Override
    public void selectLayout() {
        this.setLayout(new GridLayout(0, 1, 5, 5));
    }
}
