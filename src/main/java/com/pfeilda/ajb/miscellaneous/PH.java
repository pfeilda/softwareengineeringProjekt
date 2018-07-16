package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Labels.PHLabel;

public class PH extends Property {
    public PH(final double property) {
        super(property);
    }

    public PH() {
        super(7);
    }

    @Override
    public void addTo(final AbstractSubstance abstractSubstance) {
        abstractSubstance.add(this);
    }

    @Override
    protected void generatePropertyLabel() {
        this.propertyLabel = new PHLabel();
    }

    @Override
    public PHLabel getPropertyLabel() {
        return (PHLabel) this.propertyLabel;
    }

    private void changedProperty() {
        this.propertyLabel.change(this);
    }
}
