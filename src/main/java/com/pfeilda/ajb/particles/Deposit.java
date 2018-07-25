package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.Property;

import java.util.Set;

public class Deposit {
    private final Element element;
    private final Element deposit;
    private final Set<Property> properties;

    public Deposit(final Element element, final Element deposit, final Set<Property> properties) {
        this.element = element;
        this.deposit = deposit;
        this.properties = properties;
    }

    public boolean isDeposit(final Element element) {
        return this.element.equals(element);
    }

    public Element get() {
        return this.deposit;
    }
}
