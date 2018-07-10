package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.Property;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class ExternalReagent implements PartInterface, Observer {
    private final ExternalReagent part;
    private final ArrayList<SubstanceContainer> substanceContainers = new ArrayList<SubstanceContainer>();
    protected Property[] alterProperties;

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

    @Override
    public void add(final SubstanceContainer substanceContainer) {
        this.substanceContainers.add(substanceContainer);
    }

    public void remove(final SubstanceContainer substanceContainer) {
        this.substanceContainers.remove(substanceContainer);
    }

    public void clear() {
        this.substanceContainers.clear();
    }

    @Override
    public void update(final Observable o, final Object arg) {
        this.substanceContainers.forEach(
                (final SubstanceContainer substanceContainer) -> substanceContainer.alter(this.alterProperties)
        );
    }
}
