package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class User extends Thread {
    public static final int ITERATIONS = 10;
    public static final int TURN_ON_FREQUENCY_IN_SECONDS = 2;
    private final AtomicBoolean toggle;

    public User(AtomicBoolean toggle) {
        this.toggle = toggle;
    }

    @Override
    public void run() {
        for (int i = 0; i < ITERATIONS; i++) {
            System.out.println("Пользователь открыл коробку");
            toggle.set(true);
            try {
                sleep(TURN_ON_FREQUENCY_IN_SECONDS * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
