package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.analysis.Reagent;
import com.pfeilda.ajb.miscellaneous.Volume;
import com.pfeilda.ajb.particles.Element;

public class ErlenmeyerFlaskTest extends SubstanceContainerTest {
    public ErlenmeyerFlaskTest() {
        this.maxVolume = new Volume(500);
    }

    @Override
    public ErlenmeyerFlask generateInstanceOfTestClass() {
        return new ErlenmeyerFlask(new Reagent(new Element[0]));
    }

    @Override
    public ErlenmeyerFlask generateInstanceOfTestClass(final AbstractSubstance abstractSubstance) {
        return new ErlenmeyerFlask(abstractSubstance);
    }
}
