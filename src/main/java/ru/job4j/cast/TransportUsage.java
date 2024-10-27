package ru.job4j.cast;

public class TransportUsage {

    public static void main(String[] args) {
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle airplane1 = new Airplane();
        Vehicle airplane2 = new Airplane();

        Vehicle[] vehicles = new Vehicle[]{bus1, bus2, train1, train2, airplane1, airplane2};

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.stop();
        }
    }
}
