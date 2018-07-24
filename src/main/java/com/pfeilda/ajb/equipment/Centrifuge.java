package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.Property;
import com.pfeilda.ajb.miscellaneous.Separation;

public class Centrifuge extends ExternalReagent {
    public Centrifuge(final ExternalReagent part) {
        super(part);
    }

    public Centrifuge() {
    }

    //todo maybe tests
    @Override
    protected void setAlterProperties() {
        this.alterProperties = new Property[]{
                new Separation(.1),
        };
    }
}
