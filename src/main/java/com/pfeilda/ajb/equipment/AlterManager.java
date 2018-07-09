package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.analysis.Reagent;
import com.pfeilda.ajb.particles.AtomFactory;
import com.pfeilda.ajb.particles.Element;

import java.util.Observable;
import java.util.Set;

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

    public static void main(final String[] args) throws Exception {
        final AlterManager alterManager = AlterManager.getInstance();

        alterManager.addObserver(new ExternalReagent());

        final Thread thread = new Thread(alterManager);
        thread.start();
        for (int i = 0; i < 10; i++) {
            alterManager.setChanged();
            Thread.sleep(500);
        }
        thread.stop();
    }

    @Override
    public void run() {
        while (true) {
            this.notifyObservers(new ExternalReagent());
        }
    }
}
