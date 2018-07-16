package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Labels.TemperatureLabel;

public class Temperature extends Property {
    public Temperature(final double property) {
        super(property);
    }

    @Override
    public void addTo(final AbstractSubstance abstractSubstance) {
        abstractSubstance.add(this);
    }

    @Override
    protected void generatePropertyLabel() {
        this.propertyLabel = new TemperatureLabel();
    }

    @Override
    public TemperatureLabel getPropertyLabel() {
        return (TemperatureLabel) this.propertyLabel;
    }
}
