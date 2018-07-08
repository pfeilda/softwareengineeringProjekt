package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.particles.Element;

import java.util.List;

public abstract class Assay extends AbstractSubstance {
    public Assay(final List<AbstractSubstance> abstractSubstances) {
        super(abstractSubstances);
    }

    public abstract boolean isDisruptiveElementPresent(Element element);

}
