package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.particles.Element;

import java.util.Arrays;
import java.util.List;

public class Reagent<Reagent extends AbstractSubstance> extends AbstractSubstance {
    //same erasure => not possible 2 constructors with list => 1 with array
    public Reagent(final List<Reagent> reagent) {
        super((List<AbstractSubstance>) reagent);
    }

    public Reagent(final Element[] elements) {
        this.addAll(Arrays.asList(elements));
    }

    public Reagent(final List<AbstractSubstance> abstractSubstances, final Element[] elements) {
        super(abstractSubstances);
        this.addAll(Arrays.asList(elements));
    }
}
