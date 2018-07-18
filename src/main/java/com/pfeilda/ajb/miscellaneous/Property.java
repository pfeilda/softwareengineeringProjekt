package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Labels.PropertyLabel;

public abstract class Property {
    protected PropertyLabel propertyLabel;
    private double property;

    public Property(final double property) {
        this.property = property;
        this.generatePropertyLabel();
    }

    public double get() {
        return this.property;
    }

    private void add(final double property) {
        this.property = this.property + property;
        this.changedProperty();
    }

    public void add(final Property property) {
        this.add(property.get());
    }

    protected abstract void generatePropertyLabel();

    public abstract PropertyLabel getPropertyLabel();

    protected void changedProperty() {
        this.propertyLabel.change(this);
    }

    public abstract void addTo(AbstractSubstance abstractSubstance);

    @Override
    public boolean equals(final Object obj) {
        if (this.getClass().equals(obj.getClass())) {
            if (this.get() == ((Property) obj).get()) {
                return true;
            }
        }
        return false;
    }
}
