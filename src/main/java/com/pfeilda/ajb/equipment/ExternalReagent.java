package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.Property;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public abstract class ExternalReagent implements PartInterface, Observer {
    private final ExternalReagent part;
    private final Set<SubstanceContainer> substanceContainers = new HashSet<>();
    protected Property[] alterProperties;

    public ExternalReagent(final ExternalReagent part) {
        this.part = part;
        this.setAlterProperties();
    }

    public ExternalReagent() {
        this.part = this;
        this.setAlterProperties();
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

    protected abstract void setAlterProperties();
}
