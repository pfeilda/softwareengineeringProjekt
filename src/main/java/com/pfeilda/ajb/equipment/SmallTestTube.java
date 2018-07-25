package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.gui.Elements.Partials.BeakerOverview;

public class SmallTestTube extends TestTube {
    protected static final double maxVolume = 10;

    public SmallTestTube(final AbstractSubstance abstractSubstance) {
        super(abstractSubstance, SmallTestTube.maxVolume);
    }

    protected SmallTestTube(final AbstractSubstance abstractSubstance, final double maxVolume) {
        super(abstractSubstance, maxVolume);
        this.assayOverview = new BeakerOverview(this, abstractSubstance);
    }

    @Override
    public SmallTestTube divide() {
        return (SmallTestTube) super.divide();
    }

    @Override
    public SmallTestTube divideWithDeposit() {
        return (SmallTestTube) super.divideWithDeposit();
    }

    @Override
    public SmallTestTube getContainer(final AbstractSubstance abstractSubstance) {
        return new SmallTestTube(abstractSubstance);
    }
}
