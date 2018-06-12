package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.Substance;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Arrays;

public class Ion extends Element {
    @JsonProperty
    private final int charge;
    @JsonProperty
    private final Atom[] atoms;

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

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Ion) {
            final Ion ion = (Ion) obj;
            if (super.equals(ion)) {
                if (ion.containSameAtoms(this.atoms)) {
                    if (ion.hasSameCharge(this.charge)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containSameAtoms(final Atom[] atoms) {
        return Arrays.equals(atoms, this.atoms);
    }

    public boolean hasSameCharge(final int charge) {
        return this.charge == charge;
    }
}
