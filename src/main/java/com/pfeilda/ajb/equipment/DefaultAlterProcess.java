package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.Pressure;
import com.pfeilda.ajb.miscellaneous.Property;
import com.pfeilda.ajb.miscellaneous.Temperature;

public class DefaultAlterProcess extends ExternalReagent {
    public DefaultAlterProcess(final ExternalReagent part) {
        super(part);
    }

    public DefaultAlterProcess() {
    }

    //todo maybe tests
    @Override
    protected void setAlterProperties() {
        this.alterProperties = new Property[]{
                new Pressure(-.01),
                new Temperature(-.01),
        };
    }
}
