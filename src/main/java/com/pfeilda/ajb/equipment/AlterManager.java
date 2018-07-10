package com.pfeilda.ajb.equipment;

import java.util.Observable;

public class AlterManager extends Observable implements Runnable {
    private static volatile AlterManager instance;
    private static final Object mutex = new Object();

    private AlterManager() {
    }

    public static AlterManager getInstance() {
        AlterManager result = AlterManager.instance;
        if (result == null) {
            synchronized (AlterManager.mutex) {
                result = AlterManager.instance;
                if (result == null) {
                    AlterManager.instance = result = new AlterManager();
                }
            }
        }
        return result;
    }

    @Override
    public void run() {
        while (true) {
            this.notifyObservers();
        }
    }
}
