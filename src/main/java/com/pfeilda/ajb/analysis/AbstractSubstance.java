package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.*;
import com.pfeilda.ajb.particles.Element;

import java.util.ArrayList;
import java.util.List;

/* PhysicalState Decorator */
public abstract class AbstractSubstance implements AlterInterface, VolumeInterface {
    private final Volume volume = new Volume(0);
    private final Temperature temperature = new Temperature(0);
    private final Pressure pressure = new Pressure(0);
    private final Volume volumePerElement = new Volume(10);
    private boolean isValid = true;
    protected final List<Element> elements = new ArrayList<>();

    AbstractSubstance(final List<AbstractSubstance> abstractSubstances) {
        for (final AbstractSubstance abstractSubstance :
                abstractSubstances) {
            abstractSubstance.addTo(this);
        }
    }

    protected AbstractSubstance() {
    }

    @Override
    public abstract void alter();

    public void add(final Element element) {
        this.elements.add(element);
        this.add(this.volumePerElement);
    }

    @Override
    public void add(final Volume volume) {
        this.volume.add(volume.get());
    }

    public void addAll(final List<Element> elements) {
        this.elements.addAll(elements);
        this.volume.add(this.volumePerElement.get() * elements.size());
    }

    public void addTo(final AbstractSubstance abstractSubstance) {
        abstractSubstance.add(this.getVolume());
        for (final Element element :
                this.elements) {
            abstractSubstance.add(element);
        }
    }

    public final Volume getVolume() {
        return this.volume;
    }

    public final Temperature getTemperature() {
        return this.temperature;
    }

    public final Pressure getPressure() {
        return this.pressure;
    }

    public final void destroy() {
        this.isValid = false;
    }

    public final boolean isValid() {
        return this.isValid;
    }
}
