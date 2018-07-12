package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.FileUtility;
import com.pfeilda.ajb.miscellaneous.Singleton;

import java.io.File;
import java.util.Arrays;

public class AnalyseElementFactory implements Singleton {
    private static volatile AnalyseElementFactory instance;
    private static final Object mutex = new Object();
    private final AnalyseElement[] analyseElements;

    public AnalyseElementFactory() {
        final FileUtility fileUtility = FileUtility.getInstance();
        final File analyseElementsFile = new File(
                this.getClass().getResource("/Particles/AnalyseElements.json").getFile()
        );

        this.analyseElements = fileUtility.readModelFromFile(
                analyseElementsFile,
                AnalyseElement[].class
        );
    }

    public static AnalyseElementFactory getInstance() {
        AnalyseElementFactory result = AnalyseElementFactory.instance;
        if (result == null) {
            synchronized (AnalyseElementFactory.mutex) {
                result = AnalyseElementFactory.instance;
                if (result == null) {
                    AnalyseElementFactory.instance = result = new AnalyseElementFactory();
                }
            }
        }
        return result;
    }

    public final AnalyseElement get(final Element element) {
        return Arrays.stream(this.analyseElements)
                .filter(analyseElement -> analyseElement.get().equals(element))
                .findFirst()
                .orElse(null);
    }
}
