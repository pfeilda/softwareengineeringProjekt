package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.AlterInterface;
import com.pfeilda.ajb.miscellaneous.Volume;
import com.pfeilda.ajb.miscellaneous.VolumeInterface;

/* PhysicalState Decorator */
public abstract class Substance implements AlterInterface, VolumeInterface {
    private final Volume volume;
    private final double temperature;
    private final double pressure;
    private boolean isValid = true;

    Substance(final Volume volume, final double temperature, final double pressure) {
        this.volume = volume;
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public abstract void alter();

    public abstract void react(Substance substance);

    public abstract void add(Substance substance);

    public void add(final Volume volume) {
        this.volume.add(volume.get());
    }

    public final Volume getVolume() {
        return this.volume;
    }


    public final double getTemperature() {
        return this.temperature;
    }

    public final double getPressure() {
        return this.pressure;
    }

    public final void destroy() {
        this.isValid = false;
    }

    public final boolean isValid() {
        return this.isValid;
    }
}
