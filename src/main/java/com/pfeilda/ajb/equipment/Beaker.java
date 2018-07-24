package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.miscellaneous.Volume;

public class Beaker extends SubstanceContainer {
    private static final double maxVolume = 50;

    public Beaker(final AbstractSubstance abstractSubstance) {
        super(abstractSubstance, new Volume(Beaker.maxVolume));
    }

    @Override
    public Beaker divide() {
        final AbstractSubstance abstractSubstance = this.abstractSubstance.divide();
        if (abstractSubstance == null) {
            return null;
        }
        return new Beaker(abstractSubstance);
    }

    @Override
    public SubstanceContainer divideWithDeposit() {
        final AbstractSubstance abstractSubstance = this.abstractSubstance.divideWithDeposit();
        if (abstractSubstance == null) {
            return null;
        }
        return new Beaker(abstractSubstance);
    }
}
