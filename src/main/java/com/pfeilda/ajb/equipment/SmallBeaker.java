package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;

public class SmallBeaker extends Beaker {
    protected static final double maxVolume = 50;

    public SmallBeaker(final AbstractSubstance abstractSubstance) {
        super(abstractSubstance, SmallBeaker.maxVolume);
    }

    @Override
    public SmallBeaker divide() {
        return (SmallBeaker) super.divide();
    }

    @Override
    public SmallBeaker divideWithDeposit() {
        return (SmallBeaker) super.divideWithDeposit();
    }

    @Override
    public SmallBeaker getContainer(final AbstractSubstance abstractSubstance) {
        return new SmallBeaker(abstractSubstance);
    }
}
