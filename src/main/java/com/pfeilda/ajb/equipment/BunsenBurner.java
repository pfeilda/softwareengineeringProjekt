package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.Pressure;
import com.pfeilda.ajb.miscellaneous.Property;
import com.pfeilda.ajb.miscellaneous.Temperature;

public class BunsenBurner extends ExternalReagent {
    public BunsenBurner(final ExternalReagent part) {
        super(part);
    }

    public BunsenBurner() {
    }

    //todo maybe tests
    @Override
    protected void setAlterProperties() {
        this.alterProperties = new Property[]{
                new Temperature(.1),
                new Pressure(.1),
        };
    }
}
