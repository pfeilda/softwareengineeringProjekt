package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;

public interface PartInterface {
    public void alter();

    public void add(AbstractSubstance substance);

    public AbstractSubstanceContainer getSubstanceContainer();
}
