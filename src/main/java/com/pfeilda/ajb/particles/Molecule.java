package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.Substance;

public class Molecule extends Element {
    private final Ion[] ions;

    public Molecule(final String label, final Ion[] ions) {
        super(label);
        this.ions = ions;
    }

    public Ion[] getIons() {
        return this.ions;
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
