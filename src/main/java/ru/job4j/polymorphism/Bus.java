package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move(int wheel) {
        return 0;
    }

    @Override
    public void passengers (int count) {
        return 0;
    }

    @Override
    public int refuel (int fuel) {
        return 0;
    }

}
