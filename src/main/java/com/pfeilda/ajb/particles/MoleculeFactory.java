package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.FileUtility;
import com.pfeilda.ajb.miscellaneous.Singleton;

import java.io.File;

public class MoleculeFactory implements Singleton {
    private static volatile MoleculeFactory instance;
    private static final Object mutex = new Object();
    private final Molecule[] molecules;

    public MoleculeFactory() {
        final FileUtility fileUtility = FileUtility.getInstance();
        final File moleculeFile = new File(this.getClass().getResource("/Particles/Molecules.json").getFile());
        this.molecules = fileUtility.readModelFromFile(moleculeFile, Molecule[].class);
    }

    public static MoleculeFactory getInstance() {
        MoleculeFactory result = MoleculeFactory.instance;
        if (result == null) {
            synchronized (MoleculeFactory.mutex) {
                result = MoleculeFactory.instance;
                if (result == null) {
                    MoleculeFactory.instance = result = new MoleculeFactory();
                }
            }
        }
        return result;
    }

    public Molecule get(final String label) {
        for (final Molecule molecule :
                this.molecules) {
            if (molecule.getLabel().equals(label)) {
                return molecule;
            }
        }
        return null;
    }
}
