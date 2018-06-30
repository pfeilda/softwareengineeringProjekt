package com.pfeilda.ajb.miscellaneous;

public class Volume {
    private double volume;

    public Volume(final double volume) {
        this.volume = volume;
    }

    public double get() {
        return this.volume;
    }

    public void add(final double volume) {
        this.volume = volume;
    }
}
