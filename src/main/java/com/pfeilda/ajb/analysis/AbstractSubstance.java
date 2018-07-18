package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.equipment.AlterInterface;
import com.pfeilda.ajb.miscellaneous.*;
import com.pfeilda.ajb.particles.Element;

import java.util.HashSet;
import java.util.Set;

/* PhysicalState Decorator */
public abstract class AbstractSubstance implements AlterInterface, VolumeInterface {
    private final Volume volume = new Volume(0);
    private final Temperature temperature = new Temperature(0);
    private final Pressure pressure = new Pressure(0);
    private final PH ph = new PH();
    private final Volume volumePerElement = new Volume(10);
    private boolean isValid = true;
    protected final Set<Element> elements = new HashSet<>();

    AbstractSubstance(final Set<AbstractSubstance> abstractSubstances) {
        for (final AbstractSubstance abstractSubstance :
                abstractSubstances) {
            abstractSubstance.addTo(this);
        }
    }

    protected AbstractSubstance() {
        this.volume.add(this.volumePerElement);
    }

    //todo refactor + test
    public final Set<Property> getProperties() {
        final Set<Property> properties = new HashSet<>();

        properties.add(this.volume);
        properties.add(this.temperature);
        properties.add(this.ph);
        properties.add(this.pressure);

        return properties;
    }

    public final void add(final Element element) {
        this.elements.add(element);
        this.add(this.volumePerElement);
    }

    public final void addAll(final Set<Element> elements) {
        this.elements.addAll(elements);
        final double addVolumeSize = this.volumePerElement.get() * elements.size();
        final Volume addVolume = new Volume(addVolumeSize);
        this.volume.add(addVolume);
    }

    public final void addTo(final AbstractSubstance abstractSubstance) {
        abstractSubstance.add(this.getVolume());
        for (final Element element :
                this.elements) {
            abstractSubstance.add(element);
        }
    }

    @Override
    public void add(final Volume volume) {
        this.volume.add(volume);
    }

    public void add(final Temperature temperature) {
        this.temperature.add(temperature);
    }

    public void add(final Pressure pressure) {
        this.pressure.add(pressure);
    }

    public void add(final PH ph) {
        this.ph.add(ph);
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

    public PH getPh() {
        return this.ph;
    }

    private final void generateDeposit(final Element element) {

    }

    private final void generateDeposit(final Set<Element> elements) {
        elements.forEach(this::generateDeposit);
    }

    public final void destroy() {
        this.isValid = false;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    @Override
    public void alter(final Property[] properties) {
        for (final Property property :
                properties) {
            property.addTo(this);
        }
    }
}
