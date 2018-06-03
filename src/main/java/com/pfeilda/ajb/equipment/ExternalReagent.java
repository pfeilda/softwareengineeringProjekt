package com.pfeilda.ajb.equipment;

import java.util.ArrayList;

public abstract class ExternalReagent implements PartInterface {
    private final ExternalReagent part;
    private final ArrayList<SubstanceContainer> substanceContainers = new ArrayList<SubstanceContainer>();

    public ExternalReagent(final ExternalReagent part) {
        this.part = part;
    }

    public ExternalReagent() {
        this.part = this;
    }

    PartInterface getParent() {
        if (this.part == this) {
            return this;
        } else {
            return this.part.getParent();
        }
    }

    public void add(final SubstanceContainer substanceContainer) {
        this.substanceContainers.add(substanceContainer);
    }

    public void remove(final SubstanceContainer substanceContainer) {
        this.substanceContainers.add(substanceContainer);
    }

    public void clear() {
        this.substanceContainers.clear();
    }
}
