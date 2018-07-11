package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.analysis.Assay;

import java.util.Random;
import java.util.Set;

public class AnalyseElement implements AnalysisInterface {
    private final Element element;
    private final Set<Element> disruptiveElements;

    public AnalyseElement(final Element element, final Set<Element> disruptiveElements) {
        this.element = element;
        this.disruptiveElements = disruptiveElements;
    }

    public boolean experimentalProof(final Assay abstractSubstance, final Set<Element> analysisElements) {
        if (!abstractSubstance.isDisruptiveElementPresent(this.disruptiveElements)) {
            for (final AnalysisInterface analysisElement :
                    analysisElements) {
                if (this.element.equals(analysisElement)) {
                    return true;
                }
            }
            return false;
        }
        final Random random = new Random();
        return random.nextBoolean();
    }
}
