package com.pfeilda.ajb.gui.Elements.Buttons;

import com.pfeilda.ajb.analysis.Reagent;
import com.pfeilda.ajb.equipment.SubstanceContainer;
import com.pfeilda.ajb.gui.Elements.Dialog.AddElementDialog;
import com.pfeilda.ajb.particles.AnalyseElement;
import com.pfeilda.ajb.particles.Element;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class AddElement extends JButton {
    private final AddElementDialog parent;
    private final AnalyseElement analyseElement;
    private final SubstanceContainer substanceContainer;

    public AddElement(final SubstanceContainer substanceContainer, final AnalyseElement analyseElement, final AddElementDialog parent) {
        this.parent = parent;
        this.analyseElement = analyseElement;
        this.substanceContainer = substanceContainer;

        this.setText(analyseElement.get().getLabel());

        this.addActionListener(this::addElement);
    }

    private final void addElement(final ActionEvent actionEvent) {
        this.substanceContainer.add(
                new Reagent(new Element[]{
                        this.analyseElement.get()
                })
        );

        this.parent.setVisible(false);
        this.parent.dispose();
        this.parent.setModal(false);
        System.out.println("test");
    }
}
