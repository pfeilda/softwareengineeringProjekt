package com.pfeilda.ajb.particles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pfeilda.ajb.analysis.Substance;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Atom extends Element implements Comparable {
    private final String elementSymbol;
    private final int atomicNumber;

    Atom(
            @JsonProperty("name") final String label,
            @JsonProperty("symbol") final String elementSymbol,
            @JsonProperty("number") final int atomicNumber
    ) {
        super(label);
        this.elementSymbol = elementSymbol;
        this.atomicNumber = atomicNumber;
    }

    public String getElementSymbol() {
        return this.elementSymbol;
    }

    public int getAtomicNumber() {
        return this.atomicNumber;
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
                    if (this.getAtomicNumber() == atom.getAtomicNumber()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int compareTo(final Object o) {
        return this.getAtomicNumber() - ((Atom) o).getAtomicNumber();
    }
}
