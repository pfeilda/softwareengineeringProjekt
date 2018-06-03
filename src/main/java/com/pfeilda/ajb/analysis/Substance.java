package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.AlterInterface;
import com.pfeilda.ajb.miscellaneous.Volume;
import com.pfeilda.ajb.miscellaneous.VolumeInterface;
import com.pfeilda.ajb.particles.Element;

import java.util.ArrayList;

/* PhysicalState Decorator */
public abstract class Substance implements AlterInterface, VolumeInterface {
    private final Volume volume = new Volume(0);
    private double temperature = 0;
    private double pressure = 0;
    private boolean isValid = true;
    protected final ArrayList<Element> elements = new ArrayList<Element>();

    Substance(final Substance[] substances) {
        for (final Substance substance :
                substances) {
            substance.addTo(this);
        }
    }

    public abstract void alter();

    abstract void add(Element element);

    public void addTo(final Substance substance) {
        substance.add(this.getVolume());
        for (final Element element :
                this.elements) {
            substance.add(element);
        }
    }

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
