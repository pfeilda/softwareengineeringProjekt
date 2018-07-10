package com.pfeilda.ajb.particles;

import java.util.HashSet;
import java.util.Set;

public class DisruptiveElements {
    private final Set<Element> elements = new HashSet<>();
    private final Element element;

    public DisruptiveElements(
            final Element element,
            final int[] atomicNumbers,
            final String[] ionLabels,
            final String[] molculeLabels
    ) {
        final AtomFactory atomFactory = AtomFactory.getInstance();
        final IonFactory ionFactory = IonFactory.getInstance();
        final MoleculeFactory moleculeFactory = MoleculeFactory.getInstance();

        this.element = element;

        for (final int atomicNumber :
                atomicNumbers) {
            this.elements.add(atomFactory.get(atomicNumber));
        }

        for (final String ionLabel :
                ionLabels) {
            this.elements.add(ionFactory.get(ionLabel));
        }

        for (final String moleculeLabel :
                molculeLabels) {
            this.elements.add(moleculeFactory.get(moleculeLabel));
        }
    }

    public boolean isDisruptive(final Element element) {
        return this.elements.contains(element);
    }

    public Element getElement() {
        return this.element;
    }
}
