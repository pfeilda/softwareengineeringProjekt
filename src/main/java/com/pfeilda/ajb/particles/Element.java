package com.pfeilda.ajb.particles;

public abstract class Element {
    private final String label;

    Element(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    /** todo template method verschiedene aufrufe ergeben das ergebniss */
    public abstract boolean experimentalProof();
}
