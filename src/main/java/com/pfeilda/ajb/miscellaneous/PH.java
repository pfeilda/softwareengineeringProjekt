package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;

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
}
