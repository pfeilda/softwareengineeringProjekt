package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Labels.TemperatureLabel;

public class Temperature extends Property {
    public Temperature(final double property) {
        super(property, 0, 300);
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
        this.changedProperty();
        return (TemperatureLabel) this.propertyLabel;
    }

    @Override
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
        super.add(new Temperature(difference));
    }
}
