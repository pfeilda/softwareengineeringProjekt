package com.pfeilda.ajb.miscellaneous;

import com.pfeilda.ajb.analysis.AbstractSubstance;

public class Evaporate extends Volume {
    public Evaporate(final double property) {
        super(property);
    }

    @Override
    public void addTo(final AbstractSubstance abstractSubstance) {
        if (abstractSubstance.isEvaporating())
            super.addTo(abstractSubstance);
    }
}
