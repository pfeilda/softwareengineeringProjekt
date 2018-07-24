package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Buttons.EvaluateButton;
import com.pfeilda.ajb.particles.AnalyseElement;
import com.pfeilda.ajb.particles.AnalyseElementFactory;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class GlobalAssayActions extends AbstractPartial {
    private final SubstanceContainer substanceContainer;

    public GlobalAssayActions(final SubstanceContainer substanceContainer) {
        this.substanceContainer = substanceContainer;

        this.initial();
    }

    @Override
    public void selectLayout() {

    }

    @Override
    public void addComponents() {
        this.addElementPanel();
    }

    @Override
    public void addActionButtons() {
        this.add(new EvaluateButton(this.substanceContainer));
    }

    private void addElementPanel() {
        final AnalyseElementFactory analyseElementFactory = AnalyseElementFactory.getInstance();
        final AnalyseElement[] analyseElements = analyseElementFactory.getAll();

        final JPanel elementsPanel = new JPanel();

        Arrays.stream(analyseElements).forEach((analyseElement) -> {
            final JCheckBox elementCheckbox = new JCheckBox(analyseElement.get().getLabel());
            elementCheckbox.addActionListener((ActionEvent actionEvent) -> {
                if (elementCheckbox.isSelected()) {
                    this.substanceContainer.markAsFound(analyseElement.get());
                } else {
                    this.substanceContainer.unmarkAsFound(analyseElement.get());
                }
            });

            elementsPanel.add(elementCheckbox);
        });

        this.add(elementsPanel);
    }
}
