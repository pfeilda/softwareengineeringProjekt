package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.particles.Element;

import java.util.Random;

public abstract class Assay extends AbstractSubstance {
    protected final Element[] elements;

    public Assay(final Element[] elements) {
        this.elements = elements;
    }

    public abstract boolean isDisruptiveElementPresent(Element element);

    public boolean isElementPresent(final Element element) {
        if (!this.isDisruptiveElementPresent(element)) {
            for (final Element elementFromArray :
                    this.elements) {
                if (element.equals(elementFromArray)) {
                    return true;
                }
            }
            return false;
        }
        final Random random = new Random();
        return random.nextBoolean();
    }
}
