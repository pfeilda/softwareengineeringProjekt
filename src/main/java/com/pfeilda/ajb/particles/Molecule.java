package com.pfeilda.ajb.particles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pfeilda.ajb.analysis.Assay;

import java.util.Arrays;
import java.util.Set;

public class Molecule extends Element {
    private final Ion[] ions;

    Molecule(final String label, final Ion[] ions) {
        super(label);
        this.ions = ions;
    }

    Molecule(final String label, final Set<Ion> ions) {
        super(label);
        this.ions = ions.toArray(new Ion[]{});
    }

    Molecule(
            @JsonProperty("label") final String label,
            @JsonProperty("ions") final String[] ionLabels
    ) {
        super(label);

        this.ions = new Ion[ionLabels.length];

        final IonFactory ionFactory = IonFactory.getInstance();
        for (int i = 0; i < ionLabels.length; i++) {
            this.ions[i] = ionFactory.get(ionLabels[i]);
        }
    }

    public Ion[] getIons() {
        return this.ions;
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
