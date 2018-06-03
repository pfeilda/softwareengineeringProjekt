package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.Substance;

public class Ion extends Element {
    private final Atom[] atoms;
    private final int charge;

    public Ion(final String label, final Atom[] atoms, final int charge) {
        super(label);
        this.atoms = atoms;
        this.charge = charge;
    }

    @Override
    public boolean experimentalProof(final Substance substance) {
        return true;
    }

    //todo remove mock
    public boolean experimentalProof(final boolean mock) {
        return mock;
    }
}
