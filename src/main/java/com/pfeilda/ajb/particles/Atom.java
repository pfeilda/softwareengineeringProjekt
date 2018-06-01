package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.AbstractSubstance;

import java.util.ArrayList;

public class Atom extends Element {
    private final String elementSymbol;
    private final int ordinal;

    Atom(final String label, final String elementSymbol, final int ordinal) {
        super(label);
        this.elementSymbol = elementSymbol;
        this.ordinal = ordinal;
    }

    public String getElementSymbol() {
        return this.elementSymbol;
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    @Override
    public boolean experimentalProof(final AbstractSubstance abstractSubstance) {
        return true;
    }

    //todo remove mock
    public boolean experimentalProof(final boolean mock) {
        return mock;
    }
}
