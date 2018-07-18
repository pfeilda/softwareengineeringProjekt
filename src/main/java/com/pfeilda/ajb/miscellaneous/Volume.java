package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Labels.VolumeLabel;

public class Volume extends Property {
    public Volume(final double property) {
        super(property, 0, 1000);
    }

    @Override
    public void addTo(final AbstractSubstance abstractSubstance) {
        abstractSubstance.add(this);
    }

    @Override
    protected void generatePropertyLabel() {
        this.propertyLabel = new VolumeLabel();
    }

    @Override
    public VolumeLabel getPropertyLabel() {
        this.changedProperty();
        return (VolumeLabel) this.propertyLabel;
    }
}
