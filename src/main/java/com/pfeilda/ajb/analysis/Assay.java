package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.particles.Element;

import java.util.Random;

public abstract class Assay extends AbstractSubstance {
    public abstract boolean isDisruptiveElementPresent(Element element);

    public boolean elementIsPresent(final Element element) {
        if (!this.isDisruptiveElementPresent(element)) {
            return this.elements.contains(element);
        }
        final Random random = new Random();
        return random.nextBoolean();
    }
}
