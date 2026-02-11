package ru.job4j.cast;

public class VehicleAll {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();

        Vehicle[] all = new Vehicle[] {airplane, bus,train};
        for (Vehicle object : all) {
            object.move();
        }
    }
}
