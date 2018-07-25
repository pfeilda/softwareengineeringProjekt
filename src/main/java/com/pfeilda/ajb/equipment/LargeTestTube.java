package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Partials.BeakerOverview;

public class LargeTestTube extends TestTube {
    protected static final double maxVolume = 20;

    public LargeTestTube(final AbstractSubstance abstractSubstance) {
        super(abstractSubstance, LargeTestTube.maxVolume);
    }

    protected LargeTestTube(final AbstractSubstance abstractSubstance, final double maxVolume) {
        super(abstractSubstance, maxVolume);
        this.assayOverview = new BeakerOverview(this, abstractSubstance);
    }

    @Override
    public LargeTestTube divide() {
        return (LargeTestTube) super.divide();
    }

    @Override
    public LargeTestTube divideWithDeposit() {
        return (LargeTestTube) super.divideWithDeposit();
    }

    @Override
    public LargeTestTube getContainer(final AbstractSubstance abstractSubstance) {
        return new LargeTestTube(abstractSubstance);
    }
}
