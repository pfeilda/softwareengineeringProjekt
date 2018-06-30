package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.FileUtility;
import com.pfeilda.ajb.miscellaneous.Singleton;

import java.io.File;
import java.util.Arrays;

public class ParticleFactory implements Singleton {
    private static volatile ParticleFactory instance;
    private static final Object mutex = new Object();

    private final Atom[] atoms;
    private final Ion[] ions;

    private ParticleFactory() {
        final FileUtility fileUtility = FileUtility.getInstance();
        final File atomFile = new File(this.getClass().getResource("/Particles/Atoms.json").getFile());
        this.atoms = fileUtility.readModelFromFile(atomFile, Atom[].class);
        Arrays.sort(this.atoms);

        /*final File ionFile = new File(this.getClass().getResource("/Particles/Ions.json").getFile());
        this.ions = fileUtility.readModelFromFile(ionFile, Ion[].class);
        Arrays.sort(this.ions);*/
        this.ions = new Ion[5];
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
        final int atomIndex = (atomicNumber - 1);
        if (this.atoms.length > atomIndex && atomIndex >= 0) {
            return this.atoms[atomIndex];
        }
        return null;
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
