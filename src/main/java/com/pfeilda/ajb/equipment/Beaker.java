package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.miscellaneous.Volume;

public class Beaker extends SubstanceContainer {
    private static final double maxVolume = 50;

    public Beaker(final AbstractSubstance abstractSubstance) {
        super(abstractSubstance, new Volume(Beaker.maxVolume));
    }
}
