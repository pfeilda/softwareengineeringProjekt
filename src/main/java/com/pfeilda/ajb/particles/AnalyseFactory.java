package com.pfeilda.ajb.particles;

import com.pfeilda.ajb.miscellaneous.Singleton;

public class AnalyseFactory implements Singleton {
    private static volatile AnalyseFactory instance;
    private static final Object mutex = new Object();
    //private final atomAnalyses;   

    public AnalyseFactory() {

    }

    public static AnalyseFactory getInstance() {
        AnalyseFactory result = AnalyseFactory.instance;
        if (result == null) {
            synchronized (AnalyseFactory.mutex) {
                result = AnalyseFactory.instance;
                if (result == null) {
                    AnalyseFactory.instance = result = new AnalyseFactory();
                }
            }
        }
        return result;
    }
}
