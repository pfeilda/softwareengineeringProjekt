package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Labels.PropertyLabel;

//todo add in help section that there is no possibility to get under minimum
public abstract class Property {
    protected PropertyLabel propertyLabel;
    private double property;
    private boolean isValid = true;
    protected final double minimum;
    protected final double maximum;

    public Property(final double property, final double minimum, final double maximum) {
        this.property = property;
        this.minimum = minimum;
        this.maximum = maximum;
        this.setValid();
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

    public boolean isValid() {
        return this.isValid;
    }

    private void setValid() {
        if (
                this.isValid &&
                        (
                                this.minimum > this.property ||
                                        this.maximum < this.property
                        )
                )
            this.isValid = false;
    }

    protected abstract void generatePropertyLabel();

    public abstract PropertyLabel getPropertyLabel();

    protected void changedProperty() {
        this.setValid();
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
