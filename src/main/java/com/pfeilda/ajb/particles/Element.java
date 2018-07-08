package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.AbstractSubstance;

public abstract class Element {
    private final String label;

    Element(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    /**
     * todo template method verschiedene aufrufe ergeben das ergebniss
     */
    public abstract boolean experimentalProof(AbstractSubstance abstractSubstance);

    @Override
    public boolean equals(final Object obj) {
        final Element element = (Element) obj;
        return element.getLabel().equals(this.label);
    }
}
