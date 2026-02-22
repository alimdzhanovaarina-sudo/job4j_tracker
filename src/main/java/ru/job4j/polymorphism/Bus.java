package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Едет");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Пассажиров:" + count);
    }

    @Override
    public int refuel(int fuel) {
        return 0;
    }

}
