package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.particles.Element;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Reagent<Reagent extends AbstractSubstance> extends AbstractSubstance {
    //same erasure => not possible 2 constructors with list => 1 with array
    public Reagent(final Set<Reagent> reagent) {
        super((Set<AbstractSubstance>) reagent);
    }

    //todo refactor make caller with set
    public Reagent(final Element[] elements) {
        this.addAll(new HashSet<>(Arrays.asList(elements)));
    }

    public Reagent(final Set<AbstractSubstance> abstractSubstances, final Element[] elements) {
        super(abstractSubstances);
        this.addAll(new HashSet<>(Arrays.asList(elements)));
    }
}
