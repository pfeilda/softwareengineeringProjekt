package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.Singleton;

import java.util.ArrayList;

public class ParticleFactory implements Singleton {
    private static volatile ParticleFactory instance;
    private static final Object mutex = new Object();

    private final AtomFactory atomFactory;
    private final Ion[] ions;
    private final ArrayList<Molecule> molecules;

    private ParticleFactory() {
        this.atomFactory = AtomFactory.getInstance();

        this.ions = new Ion[5];
        this.molecules = new ArrayList<>();
    }

    public static ParticleFactory getInstance() {
        ParticleFactory result = ParticleFactory.instance;
        if (result == null) {
            synchronized (ParticleFactory.mutex) {
                result = ParticleFactory.instance;
                if (result == null) {
                    ParticleFactory.instance = result = new ParticleFactory();
                }
            }
        }
        return result;
    }

    public Atom getAtom(final int atomicNumber) {
        return this.atomFactory.get(atomicNumber);
    }

    public Ion getIon(final String label) {
        return null;
    }

    public Molecule getMolecule(final String label) {
        if (label.equals("Wasser")) {
            final Ion[] ions = new Ion[]{
                    new Ion(
                            "Hydrogen",
                            new Atom[]{this.getAtom(1)},
                            1
                    ),
                    new Ion(
                            "Hydrogen",
                            new Atom[]{this.getAtom(1)},
                            1),
                    new Ion(
                            "Dioxid",
                            new Atom[]{this.getAtom(8)},
                            -2
                    )
            };

            return new Molecule("Wasser", ions);

        }
        return null;
    }
}
