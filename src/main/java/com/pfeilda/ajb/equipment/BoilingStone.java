package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.Pressure;
import com.pfeilda.ajb.miscellaneous.Property;

public class BoilingStone extends ExternalReagent {
    public BoilingStone(final ExternalReagent part) {
        super(part);
    }

    public BoilingStone() {
    }

    //todo maybe tests
    @Override
    protected void setAlterProperties() {
        this.alterProperties = new Property[]{
                new Pressure(-.2),
        };
    }
}
