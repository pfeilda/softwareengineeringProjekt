package com.pfeilda.ajb.particles;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.pfeilda.ajb.analysis.Substance;

import java.util.Arrays;

public class Ion extends Element {
    private final int charge;
    private final Atom[] atoms;

    public Ion(
            final String label,
            final Atom[] atoms,
            final int charge
    ) {
        super(label);
        this.atoms = atoms;
        this.charge = charge;
    }

    public Ion(
            @JsonProperty("label") final String label,
            @JsonProperty("atoms") final int[] atomOrdinals,
            @JsonProperty("charge") final int charge
    ) {
        super(label);
        final ParticleFactory particelFactories = ParticleFactory.getInstance();
        
        final Atom[] atom = new Atom[atomOrdinals.length];
        for (int i = 0; i < atomOrdinals.length; i++) {
            atom[i] = particelFactories.getAtom(atomOrdinals[i]);
        }
        this.atoms = atom;
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
