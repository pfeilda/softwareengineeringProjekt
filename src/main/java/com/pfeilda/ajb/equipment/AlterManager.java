package com.pfeilda.ajb.equipment;

import com.pfeilda.ajb.miscellaneous.Log;

import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AlterManager extends Observable implements Runnable {
    private static volatile AlterManager instance;
    private static final Object mutex = new Object();
    private final AtomicInteger speed = new AtomicInteger(100);
    private final AtomicBoolean pause = new AtomicBoolean(false);

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
            this.setChanged();
            this.notifyObservers();
            try {
                while (this.pause.get()) {

                }
                Thread.sleep(this.speed.get());
            } catch (final InterruptedException e) {
                Log.log(this.getClass().getName(), e, "Failed Sleep For Altering.");
            }
        }
    }

    public void setSpeed(final int speed) {
        if (speed == 0) {
            this.pause.set(true);
            return;
        }
        this.pause.set(false);
        this.speed.set(speed);
    }

    public AtomicInteger getSpeed() {
        return this.speed;
    }
}
