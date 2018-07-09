package com.pfeilda.ajb.equipment;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;

public class ExternalReagent implements PartInterface, Observer {
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

    @Override
    public void add(final SubstanceContainer substanceContainer) {
        this.substanceContainers.add(substanceContainer);
    }

    public void remove(final SubstanceContainer substanceContainer) {
        this.substanceContainers.add(substanceContainer);
    }

    public void clear() {
        this.substanceContainers.clear();
    }

    @Override
    public void update(final Observable o, final Object arg) {
        final ExternalReagent externalReagent = this;
        this.substanceContainers.forEach(
                (final SubstanceContainer substanceContainer) -> substanceContainer.alter(externalReagent)
        );
    }
}
