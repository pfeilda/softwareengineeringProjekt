package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.Volume;
import com.pfeilda.ajb.particles.Element;

public abstract class Assay extends Substance {
    public Assay(final Volume volume, final double temperature, final double pressure) {
        super(volume, temperature, pressure);
    }

    public abstract boolean isDisruptiveElementPresent(Element element);

}
