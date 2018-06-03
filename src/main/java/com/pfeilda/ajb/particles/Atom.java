package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.Substance;

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
    public boolean experimentalProof(final Substance substance) {
        return true;
    }

    //todo remove mock
    public boolean experimentalProof(final boolean mock) {
        return mock;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Atom) {
            if (super.equals(obj)) {
                final Atom atom = (Atom) obj;
                if (this.getElementSymbol().equals(atom.getElementSymbol())) {
                    if (this.getOrdinal() == atom.getOrdinal()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
