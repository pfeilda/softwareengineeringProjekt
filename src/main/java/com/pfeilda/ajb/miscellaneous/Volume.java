package com.pfeilda.ajb.miscellaneous;

import org.codehaus.jackson.annotate.JsonProperty;

public class Volume {
    private double volume;

    public Volume(@JsonProperty("volume") final double volume) {
        this.volume = volume;
    }

    public double get() {
        return this.volume;
    }

    public void add(final double volume) {
        this.volume = volume;
    }
}
