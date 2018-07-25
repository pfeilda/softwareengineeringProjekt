package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Partials.BeakerOverview;
import com.pfeilda.ajb.miscellaneous.Volume;

public class Beaker extends SubstanceContainer {
    protected static final double maxVolume = 100;

    public Beaker(final AbstractSubstance abstractSubstance) {
        super(abstractSubstance, new Volume(Beaker.maxVolume));
        this.assayOverview = new BeakerOverview(this, abstractSubstance);
    }

    protected Beaker(final AbstractSubstance abstractSubstance, final double maxVolume) {
        super(abstractSubstance, new Volume(maxVolume));
        this.assayOverview = new BeakerOverview(this, abstractSubstance);
    }

    @Override
    public Beaker divide() {
        final AbstractSubstance abstractSubstance = this.abstractSubstance.divide();
        if (abstractSubstance == null) {
            return null;
        }
        return this.getContainer(abstractSubstance);
    }

    @Override
    public Beaker divideWithDeposit() {
        final AbstractSubstance abstractSubstance = this.abstractSubstance.divideWithDeposit();
        if (abstractSubstance == null) {
            return null;
        }
        return this.getContainer(abstractSubstance);
    }

    @Override
    public Beaker getContainer(final AbstractSubstance abstractSubstance) {
        return new Beaker(abstractSubstance);
    }
}
