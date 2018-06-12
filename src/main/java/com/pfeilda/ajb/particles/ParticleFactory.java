package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.FileUtility;
import com.pfeilda.ajb.miscellaneous.Singleton;

import java.io.File;

public class ParticleFactory implements Singleton {
    private static volatile ParticleFactory instance;
    private static final Object mutex = new Object();

    private final Atom[] atoms;

    private ParticleFactory() {
        final FileUtility fileUtility = FileUtility.getInstance();
        final File file = new File(this.getClass().getResource("/Particles/Atoms.json").getFile());
        this.atoms = fileUtility.readModelFromFile(file, Atom[].class);
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

    public Atom getAtom(final int ordinal) {
        if (ordinal == 1) {
            return new Atom("Hydrogen", "H", 1);
        } else if (ordinal == 8) {
            return new Atom("Sauerstoff", "O", 8);
        }
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
