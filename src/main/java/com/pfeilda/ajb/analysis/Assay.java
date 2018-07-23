package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.particles.AnalysisInterface;
import com.pfeilda.ajb.particles.Element;

import java.util.Set;

public abstract class Assay extends AbstractSubstance {
    protected final Set<Element> analysisElements;

    public Assay(final Set<Element> analysisElements) {
        this.analysisElements = analysisElements;
        this.elements.addAll(analysisElements);
        this.add(this.volumePerElement);
    }

    public abstract boolean isDisruptiveElementPresent(Set<Element> elements);

    public boolean isElementPresent(final AnalysisInterface element) {
        return element.experimentalProof(this, this.analysisElements);
    }
}
