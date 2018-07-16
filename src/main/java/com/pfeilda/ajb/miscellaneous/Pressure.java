package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Labels.PressureLabel;

public class Pressure extends Property {
    public Pressure(final double property) {
        super(property);
    }

    @Override
    public void addTo(final AbstractSubstance abstractSubstance) {
        abstractSubstance.add(this);
    }

    @Override
    protected void generatePropertyLabel() {
        this.propertyLabel = new PressureLabel();
    }

    @Override
    public PressureLabel getPropertyLabel() {
        return (PressureLabel) this.propertyLabel;
    }
}
