package com.pfeilda.ajb.gui.Views;

import com.pfeilda.ajb.analysis.BasicAssay;
import com.pfeilda.ajb.gui.Elements.Buttons.ReturnToMenu;
import com.pfeilda.ajb.gui.ViewContainerAbstract;
import com.pfeilda.ajb.particles.AnalyseElement;
import com.pfeilda.ajb.particles.AnalyseElementFactory;
import com.pfeilda.ajb.particles.Element;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StartGameView extends View {
    private final Set<Element> analyseElements = new HashSet<>();

    public StartGameView(final ViewContainerAbstract parent) {
        super(parent, "Spielstart");
    }

    @Override
    public void addComponents() {
        final AnalyseElementFactory analyseElementFactory = AnalyseElementFactory.getInstance();
        final AnalyseElement[] analyseElements = analyseElementFactory.getAll();

        Arrays.stream(analyseElements).forEach((AnalyseElement analyseElement) -> {
            final JCheckBox elementCheckbox = new JCheckBox(analyseElement.get().getLabel());
            elementCheckbox.addActionListener((ActionEvent actionEvent) -> {
                if (elementCheckbox.isSelected()) {
                    this.analyseElements.add(analyseElement.get());
                } else {
                    this.analyseElements.remove(analyseElement.get());
                }
            });

            this.add(elementCheckbox);
        });
    }

    @Override
    public void addActionButtons() {
        final JPanel actionButtons = new JPanel();
        actionButtons.setLayout(new BorderLayout(0, 5));

        final JButton startGame = new JButton("Spiel starten");

        startGame.addActionListener((ActionEvent actionEvent) -> {
            final BasicAssay basicAssay = new BasicAssay(this.analyseElements);
            new GameView(this.parent, basicAssay);
        });

        actionButtons.add(startGame, BorderLayout.PAGE_START);
        actionButtons.add(new ReturnToMenu(this.parent), BorderLayout.PAGE_END);

        this.add(actionButtons, BorderLayout.PAGE_END);
    }

    @Override
    public void selectLayout() {
        this.setLayout(new BorderLayout());
    }
}
