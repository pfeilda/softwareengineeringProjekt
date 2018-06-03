package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.Substance;
import com.pfeilda.ajb.miscellaneous.Volume;

public abstract class SubstanceContainer implements PartInterface {
    private final Volume maxVolume;
    private final Substance substance;
    private boolean isCleared = false;

    public SubstanceContainer(final Substance substance, final Volume maxVolume) {
        this.substance = substance;
        this.maxVolume = maxVolume;
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
            substanceContainer.add(this.substance);
            substanceContainer.clear();
        }
    }

    public void addTo(final SubstanceContainer substanceContainer) {
        substanceContainer.decant(substanceContainer);
    }

    public void add(final Substance substance) {
        if (this.isAllowed()) {
            this.substance.addTo(substance);
            this.validateVolume();
        }
    }

    private boolean isAllowed() {
        if (this.isCleared() || !this.substance.isValid()) {
            return false;
        }
        return true;
    }

    private void validateVolume() {
        if (this.maxVolume.get() < this.substance.getVolume().get()) {
            this.substance.destroy();
        }
    }
}
