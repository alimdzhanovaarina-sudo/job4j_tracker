package ru.job4j.polymorphism;

public interface Transport {
    void move(int wheel);
    void passengers(int count);
    int refuel(int fuel);
}
