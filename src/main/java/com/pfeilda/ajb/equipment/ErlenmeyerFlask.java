package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.miscellaneous.Volume;

public class ErlenmeyerFlask extends SubstanceContainer {
    private static final double maxVolume = 500;

    public ErlenmeyerFlask(final AbstractSubstance abstractSubstance) {
        super(abstractSubstance, new Volume(ErlenmeyerFlask.maxVolume));
    }

    @Override
    public ErlenmeyerFlask divide() {
        final AbstractSubstance abstractSubstance = this.abstractSubstance.divide();
        if (abstractSubstance == null) {
            return null;
        }
        return new ErlenmeyerFlask(abstractSubstance);
    }

    @Override
    public SubstanceContainer divideWithDeposit() {
        final AbstractSubstance abstractSubstance = this.abstractSubstance.divideWithDeposit();
        if (abstractSubstance == null) {
            return null;
        }
        return new ErlenmeyerFlask(abstractSubstance);
    }
}
