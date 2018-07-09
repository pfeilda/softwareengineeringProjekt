package com.pfeilda.ajb.miscellaneous;

public abstract class Property {
    private double property;

    public Property(final double property) {
        this.property = property;
    }

    public double get() {
        return this.property;
    }

    private void add(final double property) {
        this.property = this.property + property;
    }

    public void add(final Property property) {
        this.add(property.get());
    }

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
