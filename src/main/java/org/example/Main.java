package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main {


    public static void main(String[] args) {
        AtomicBoolean toggle = new AtomicBoolean(false);
        Toy toy = new Toy(toggle);
        User user = new User(toggle);
        toy.start();
        user.start();
        try {
            user.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        toy.interrupt();
    }
}
