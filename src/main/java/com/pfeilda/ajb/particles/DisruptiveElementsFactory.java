package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.Singleton;

public class DisruptiveElementsFactory implements Singleton {
    private static volatile DisruptiveElementsFactory instance;
    private static final Object mutex = new Object();

    public static DisruptiveElementsFactory getInstance() {
        DisruptiveElementsFactory result = DisruptiveElementsFactory.instance;
        if (result == null) {
            synchronized (DisruptiveElementsFactory.mutex) {
                result = DisruptiveElementsFactory.instance;
                if (result == null) {
                    DisruptiveElementsFactory.instance = result = new DisruptiveElementsFactory();
                }
            }
        }
        return result;
    }

    public DisruptiveElements get(final Element element) {
        return null;
    }
}
