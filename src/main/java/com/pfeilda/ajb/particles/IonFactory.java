package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.FileUtility;
import com.pfeilda.ajb.miscellaneous.Singleton;

import java.io.File;

public class IonFactory implements Singleton {
    private static volatile IonFactory instance;
    private static final Object mutex = new Object();
    private final Ion[] ions;

    public IonFactory() {
        final FileUtility fileUtility = FileUtility.getInstance();
        final File ionFile = new File(this.getClass().getResource("/Particles/Ions.json").getFile());
        this.ions = fileUtility.readModelFromFile(ionFile, Ion[].class);
    }

    public static IonFactory getInstance() {
        IonFactory result = IonFactory.instance;
        if (result == null) {
            synchronized (IonFactory.mutex) {
                result = IonFactory.instance;
                if (result == null) {
                    IonFactory.instance = result = new IonFactory();
                }
            }
        }
        return result;
    }

    public Ion get(final String label) {
        for (final Ion ion :
                this.ions) {
            if (ion.getLabel().equals(label)) {
                return ion;
            }
        }
        return null;
    }
}
