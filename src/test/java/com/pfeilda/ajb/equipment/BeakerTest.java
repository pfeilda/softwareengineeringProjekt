package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.analysis.Reagent;
import com.pfeilda.ajb.miscellaneous.Volume;
import com.pfeilda.ajb.particles.Element;

public class BeakerTest extends SubstanceContainerTest {
    public BeakerTest() {
        this.maxVolume = new Volume(50);
    }

    @Override
    public Beaker generateInstanceOfTestClass() {
        return new Beaker(new Reagent(new Element[0]));
    }


    @Override
    public Beaker generateInstanceOfTestClass(final AbstractSubstance abstractSubstance) {
        return new Beaker(abstractSubstance);
    }
}
