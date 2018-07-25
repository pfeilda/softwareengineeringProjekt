package com.pfeilda.ajb.gui.Elements.Partials;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.equipment.SubstanceContainer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class AssayOverview extends JPanel {
    protected final SubstanceContainer substanceContainer;
    protected final AbstractSubstance abstractSubstance;
    protected final JLabel warning = new JLabel("Absatz vorhanden");

    public AssayOverview(final SubstanceContainer substanceContainer, final AbstractSubstance abstractSubstance) {
        this.substanceContainer = substanceContainer;
        this.abstractSubstance = abstractSubstance;
    }
}
