package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Labels.SeperationLabel;

public class Separation extends Property {
    public Separation(final double property) {
        super(property, 0, 1);
    }

    @Override
    public void addTo(final AbstractSubstance abstractSubstance) {
        abstractSubstance.add(this);
    }

    @Override
    protected void generatePropertyLabel() {
        this.propertyLabel = new SeperationLabel();
    }

    @Override
    public SeperationLabel getPropertyLabel() {
        this.changedProperty();
        return (SeperationLabel) this.propertyLabel;
    }
}