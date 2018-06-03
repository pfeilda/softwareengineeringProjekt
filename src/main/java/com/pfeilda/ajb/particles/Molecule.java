package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.Substance;

import java.util.Arrays;
import java.util.List;

public class Molecule extends Element {
    private final Ion[] ions;

    Molecule(final String label, final Ion[] ions) {
        super(label);
        this.ions = ions;
    }

    Molecule(final String label, final List<Ion> ions) {
        super(label);
        this.ions = ions.toArray(new Ion[]{});
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

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Molecule) {
            final Molecule molecule = (Molecule) obj;
            if (super.equals(molecule)) {
                if (Arrays.equals(molecule.getIons(), this.ions)) {
                    return true;
                }
            }
        }
        return false;
    }
}
