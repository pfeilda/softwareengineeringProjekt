package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.Substance;
import com.pfeilda.ajb.miscellaneous.Volume;
import com.pfeilda.ajb.miscellaneous.VolumeInterface;

public abstract class SubstanceContainer implements VolumeInterface, PartInterface {
    protected final double maxVolume = 0;
    private final Substance substance;

    public SubstanceContainer(final Substance substance) {
        this.substance = substance;
    }

    public void add(final Volume volume) {
        this.substance.add(volume);
        if (this.substance.getVolume().get() > this.maxVolume) {
            this.substance.destroy();
        }
    }

    public void add(final SubstanceContainer substanceContainer) {
        substanceContainer.add(this.substance);
    }

    public void add(final Substance substance) {
        this.substance.add(substance);
    }
}
