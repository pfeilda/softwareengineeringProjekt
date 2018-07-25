package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;

public class LargeBeaker extends Beaker {
    protected static final double maxVolume = 250;

    public LargeBeaker(final AbstractSubstance abstractSubstance) {
        super(abstractSubstance, LargeBeaker.maxVolume);
    }

    @Override
    public LargeBeaker divide() {
        return (LargeBeaker) super.divide();
    }

    @Override
    public LargeBeaker divideWithDeposit() {
        return (LargeBeaker) super.divideWithDeposit();
    }

    @Override
    public LargeBeaker getContainer(final AbstractSubstance abstractSubstance) {
        return new LargeBeaker(abstractSubstance);
    }
}