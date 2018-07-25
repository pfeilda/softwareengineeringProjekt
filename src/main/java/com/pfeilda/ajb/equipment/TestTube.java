package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Partials.BeakerOverview;
import com.pfeilda.ajb.miscellaneous.Volume;

public class TestTube extends SubstanceContainer {
    protected static final double maxVolume = 15;

    public TestTube(final AbstractSubstance abstractSubstance) {
        super(abstractSubstance, new Volume(TestTube.maxVolume));
        this.assayOverview = new BeakerOverview(this, abstractSubstance);
    }

    protected TestTube(final AbstractSubstance abstractSubstance, final double maxVolume) {
        super(abstractSubstance, new Volume(maxVolume));
        this.assayOverview = new BeakerOverview(this, abstractSubstance);
    }

    @Override
    public TestTube divide() {
        final AbstractSubstance abstractSubstance = this.abstractSubstance.divide();
        if (abstractSubstance == null) {
            return null;
        }
        return this.getContainer(abstractSubstance);
    }

    @Override
    public TestTube divideWithDeposit() {
        final AbstractSubstance abstractSubstance = this.abstractSubstance.divideWithDeposit();
        if (abstractSubstance == null) {
            return null;
        }
        return this.getContainer(abstractSubstance);
    }

    @Override
    public TestTube getContainer(final AbstractSubstance abstractSubstance) {
        return new TestTube(abstractSubstance);
    }
}
