package com.pfeilda.ajb.gui.Elements.Dialog;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.particles.AnalyseElement;
import com.pfeilda.ajb.particles.AnalyseElementFactory;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.util.Arrays;

public class AddElementDialog extends JDialog {
    public AddElementDialog(final SubstanceContainer substanceContainer) {
        final AnalyseElementFactory analyseElementFactory = AnalyseElementFactory.getInstance();
        final AnalyseElement[] analyseElements = analyseElementFactory.getAll();

        final JPanel elementsPanel = new JPanel();
        Arrays.stream(analyseElements).forEach((analyseElement) -> {
            elementsPanel.add(new com.pfeilda.ajb.gui.Elements.Buttons.AddElement(substanceContainer, analyseElement, this));
        });
        this.add(elementsPanel);

        this.setModal(true);
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(
                WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
