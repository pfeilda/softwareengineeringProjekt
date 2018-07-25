package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.particles.Element;

import java.util.Set;

public abstract class Assay extends AbstractSubstance {
    protected final Set<Element> analysisElements;

    public Assay(final Set<Element> analysisElements) {
        this.analysisElements = analysisElements;
        this.elements.addAll(analysisElements);

        analysisElements.forEach(this::generateDeposit);

        this.add(this.volumePerElement);
    }

    public abstract boolean isDisruptiveElementPresent(Set<Element> elements);

    //todo test
    public Set<Element> getElements() {
        return this.elements;
    }
}
