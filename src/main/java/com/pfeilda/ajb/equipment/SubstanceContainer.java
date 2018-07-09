package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.AbstractSubstance;
import com.pfeilda.ajb.miscellaneous.Volume;

public abstract class SubstanceContainer implements PartInterface, AlterInterface {
    private final Volume maxVolume;
    private final AbstractSubstance abstractSubstance;
    private boolean isCleared = false;

    public SubstanceContainer(final AbstractSubstance abstractSubstance, final Volume maxVolume) {
        this.abstractSubstance = abstractSubstance;
        this.maxVolume = maxVolume;
        this.validateVolume();
    }

    @Override
    //todo check if really needed
    public void add(final SubstanceContainer substanceContainer) {
        substanceContainer.decant(substanceContainer);
    }

    public Volume getMaxVolume() {
        return this.maxVolume;
    }

    public boolean isCleared() {
        return this.isCleared;
    }

    public void clear() {
        this.isCleared = true;
    }

    private void decant(final SubstanceContainer substanceContainer) {
        if (this.isAllowed()) {
            substanceContainer.add(this.abstractSubstance);
            substanceContainer.clear();
        }
    }

    public void addTo(final SubstanceContainer substanceContainer) {
        substanceContainer.decant(substanceContainer);
    }

    public void add(final AbstractSubstance abstractSubstance) {
        if (this.isAllowed()) {
            this.abstractSubstance.addTo(abstractSubstance);
            this.validateVolume();
        }
    }

    public boolean isAllowed() {
        if (this.isCleared() || !this.abstractSubstance.isValid()) {
            return false;
        }
        return true;
    }

    private void validateVolume() {
        if (this.maxVolume.get() < this.abstractSubstance.getVolume().get()) {
            this.abstractSubstance.destroy();
        }
    }

    @Override
    public void alter(final ExternalReagent externalReagent) {
        this.abstractSubstance.alter(externalReagent);
    }
}
