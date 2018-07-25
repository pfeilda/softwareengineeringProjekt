package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.equipment.AlterInterface;
import com.pfeilda.ajb.miscellaneous.*;
import com.pfeilda.ajb.particles.AnalyseElement;
import com.pfeilda.ajb.particles.AnalyseElementFactory;
import com.pfeilda.ajb.particles.Element;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/* PhysicalState Decorator */
public abstract class AbstractSubstance implements AlterInterface, VolumeInterface {
    private final Volume volume = new Volume(0);
    private final Temperature temperature = new Temperature(0);
    private final Pressure pressure = new Pressure(0);
    private final PH ph = new PH();
    private final Separation separation = new Separation(1);
    protected final Volume volumePerElement = new Volume(10);
    private boolean isValid = true;
    protected final Set<Element> elements = new HashSet<>();
    protected final Set<Element> deposit = new HashSet<>();
    private Consumer isNonValid;
    private final Temperature evaportateTemperature = new Temperature(96.);

    AbstractSubstance(final Set<AbstractSubstance> abstractSubstances) {
        for (final AbstractSubstance abstractSubstance :
                abstractSubstances) {
            abstractSubstance.addTo(this);
        }
    }

    protected AbstractSubstance() {
    }

    //todo refactor + test
    public final List<Property> getProperties() {
        final List<Property> properties = new ArrayList<>();

        properties.add(this.volume);
        properties.add(this.temperature);
        properties.add(this.ph);
        properties.add(this.pressure);
        properties.add(this.separation);

        return properties;
    }

    public final void add(final Element element) {
        this.elements.add(element);
        this.generateDeposit(element);
        this.add(this.volumePerElement);
    }

    public final void addAll(final Set<Element> elements) {
        this.elements.addAll(elements);
        final double addVolumeSize = this.volumePerElement.get() * elements.size();
        final Volume addVolume = new Volume(addVolumeSize);
        this.volume.add(addVolume);
    }

    //todo improve test volume adding
    public final void addTo(final AbstractSubstance abstractSubstance) {
        for (final Element element :
                this.elements) {
            abstractSubstance.add(element);
        }
    }

    @Override
    public void add(final Volume volume) {
        this.volume.add(volume);
        if (!this.volume.isValid()) {
            this.destroy();
        }
    }

    public void add(final Temperature temperature) {
        this.temperature.add(temperature);
        if (!this.temperature.isValid()) {
            this.destroy();
        }
    }

    public void add(final Pressure pressure) {
        this.pressure.add(pressure);
        if (!this.pressure.isValid()) {
            this.destroy();
        }
    }

    public void add(final PH ph) {
        this.ph.add(ph);
        if (!this.ph.isValid()) {
            this.destroy();
        }
    }


    public void add(final Separation separation) {
        this.separation.add(separation);
        if (!this.separation.isValid()) {
            this.destroy();
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

    public PH getPh() {
        return this.ph;
    }

    protected void generateDeposit(final Element element) {
        final AnalyseElementFactory analyseElementFactory = AnalyseElementFactory.getInstance();

        final AnalyseElement analyseElement = analyseElementFactory.get(element);
        if (analyseElement != null) {
            final Set<Element> containingElements = new HashSet<>(this.elements);
            containingElements.forEach(containingElement -> {
                if (analyseElement.isDeposite(containingElement)) {
                    this.deposit.add(containingElement);
                    this.elements.remove(containingElement);
                    this.separation.add(new Separation(-this.separation.get()));
                }
            });
        }
    }

    private final void generateDeposit(final Set<Element> elements) {
        elements.forEach(this::generateDeposit);
    }

    public final void destroy() {
        this.isValid = false;
        if (this.isNonValid != null) {
            this.isNonValid.accept(this);
        }
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public void setIsNonValid(final Consumer isNonValid) {
        this.isNonValid = isNonValid;
    }

    @Override
    public void alter(final Property[] properties) {
        for (final Property property :
                properties) {
            property.addTo(this);
        }
    }

    private void setPropertiesToNull() {
        this.add(new Volume(-this.getVolume().get()));
        this.add(new Pressure(-this.getPressure().get()));
        this.add(new PH(-this.getPh().get()));
        this.add(new Temperature(-this.getTemperature().get()));
    }

    public AbstractSubstance divide() {
        if (this.separation.get() < 1 && this.deposit.isEmpty()) {
            if (this.getVolume().get() < 2) {
                return null;
            }
            return this.divideWithOutDeposit();
        }
        return this.divideWithDeposit();
    }

    protected abstract AbstractSubstance divideWithOutDeposit();

    //    protected AbstractSubstance divideWithOutDeposit(final Class clazz) {
    protected AbstractSubstance divideWithOutDeposit(final AbstractSubstance newReagent) {
        try {
//            final Constructor<?> ctor = clazz.getConstructor(new Element[0].getClass());
//            final AbstractSubstance newReagent = (AbstractSubstance) ctor.newInstance(this.elements);
            newReagent.setPropertiesToNull();

            final double reducedVolumeValue = this.getVolume().get() / 2;
            this.add(new Volume(-reducedVolumeValue));

            newReagent.add(new Volume(reducedVolumeValue));
            newReagent.add(this.getPressure());
            newReagent.add(this.getTemperature());
            newReagent.add(this.getPh());

            return newReagent;
        } catch (final Exception e) {
            e.printStackTrace();
            //todo log
        }
        return null;
    }

    public abstract AbstractSubstance divideWithDeposit();

    public boolean isEvaporating() {
        return this.temperature.get() >= this.evaportateTemperature.get();
    }

    public boolean hasDeposit() {
        return this.deposit.isEmpty();
    }
}
