package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.particles.Element;

public abstract class Assay extends Substance {
    public Assay(final Substance[] substances) {
        super(substances);
    }

    public abstract boolean isDisruptiveElementPresent(Element element);

}
