package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class Toy extends Thread {
    private final AtomicBoolean toggle;

    public Toy(AtomicBoolean toggle) {
        this.toggle = toggle;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if (toggle.get()) {
                System.out.println("Игрушка закрыла коробку");
                toggle.set(false);
            }
        }
    }
}
