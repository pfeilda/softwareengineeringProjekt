package com.pfeilda.ajb.gui.Elements.Dialog;

import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.particles.AnalyseElement;
import com.pfeilda.ajb.particles.AnalyseElementFactory;

import javax.swing.*;
import java.awt.Dimension;
import java.util.Arrays;

public class ExperimentalProofDialog extends JDialog {
    private final AnalyseElement[] analyseElements;

    public ExperimentalProofDialog(final SubstanceContainer substanceContainer) {
        this.setTitle("Einzelnachweis");

        final AnalyseElementFactory analyseElementFactory = AnalyseElementFactory.getInstance();
        this.analyseElements = analyseElementFactory.getAll();

        final JPanel proofPanel = new JPanel();

        final JComboBox elementComboBox = new JComboBox();

        Arrays.stream(this.analyseElements).forEach(element -> elementComboBox.addItem(element));

        proofPanel.add(elementComboBox);

        //todo extract in own class
        final JButton jButton = new JButton("Auswaehlen");

        final JDialog parent = this;

        jButton.addActionListener(actionEvent -> {
            final boolean result = substanceContainer.experimentalProof((AnalyseElement) elementComboBox.getSelectedItem());

            String resultString = "Element nicht gefunden!";
            if (result) {
                resultString = "Element gefunden!";
            }

            JOptionPane.showMessageDialog(parent, resultString);
        });

        proofPanel.add(jButton);

        this.add(proofPanel);

        this.setModal(true);
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(
                WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
