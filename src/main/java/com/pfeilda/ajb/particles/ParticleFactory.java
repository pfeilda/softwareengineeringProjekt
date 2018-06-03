package com.pfeilda.ajb.particles;

public class ParticleFactory {
    private static volatile ParticleFactory instance;
    private static final Object mutex = new Object();

    private ParticleFactory() {
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

    public Molecule getMolecule(final String label) {
        if (label.equals("Wasser")) {
            final Ion[] ions = new Ion[]{
                    new Ion(
                            "Hydrogen",
                            new Atom[]{new Atom("Hydrogen", "H", 1)},
                            1
                    ),
                    new Ion(
                            "Hydrogen",
                            new Atom[]{new Atom("Hydrogen", "H", 1)},
                            1),
                    new Ion(
                            "Dioxid",
                            new Atom[]{new Atom("Sauerstoff", "O", 8)},
                            -2
                    )
            };

            return new Molecule("Wasser", ions);

        }
        return null;
    }
}
