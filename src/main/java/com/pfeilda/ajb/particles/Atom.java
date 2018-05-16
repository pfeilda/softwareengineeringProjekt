package com.pfeilda.ajb.particles;

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
    public boolean experimentalProof() {
        return true;
    }
}
