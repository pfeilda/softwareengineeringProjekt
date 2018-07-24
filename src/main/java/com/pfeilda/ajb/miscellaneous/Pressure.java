package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Labels.PressureLabel;

public class Pressure extends Property {
    public Pressure(final double property) {
        super(property, 0, 100);
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
        this.changedProperty();
        return (PressureLabel) this.propertyLabel;
    }

    @Override
    //todo write test
    public void add(final Property property) {
        if (property.get() >= 0) {
            super.add(property);
            return;
        }
        final double difference = -(this.get() - this.minimum);
        if (property.get() > difference) {
            super.add(property);
            return;
        }
        super.add(new Pressure(difference));
    }
}
