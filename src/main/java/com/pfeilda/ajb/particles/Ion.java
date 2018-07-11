package com.pfeilda.ajb.particles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.analysis.Assay;

import java.util.Arrays;
import java.util.Set;

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
        final AtomFactory atomFactory = AtomFactory.getInstance();

        final Atom[] atom = new Atom[atomOrdinals.length];
        for (int i = 0; i < atomOrdinals.length; i++) {
            atom[i] = atomFactory.get(atomOrdinals[i]);
        }
        this.atoms = atom;
        this.charge = charge;
    }

    @Override
    //todo improve body
    public boolean experimentalProof(final Assay abstractSubstance, final Set<Element> analysisElements) {
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
