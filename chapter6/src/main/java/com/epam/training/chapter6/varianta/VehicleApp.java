package com.epam.training.chapter6.varianta;

import java.time.LocalDate;
import java.util.List;

public class VehicleApp {

    public static void main(String[] args) {
        Car car = new Car("1234 AB-7", "Toyota", "Corolla", "JT2BG22K1W0123456", "Петров", DriveType.PETROL, 50, 470);
        Motorcycle motorcycle = new Motorcycle("5678 CC-1", "Yamaha", "MT-07", "JYARM331000012345", "Сидоров", DriveType.PETROL, 14);
        Quad quad = new Quad("9012 EE-3", "Polaris", "Sportsman", "4XAGH76A5AA012345", "Козлов", DriveType.DIESEL, 40);
        Bicycle bicycle = new Bicycle("-", "Giant", "Talon", "WTU123456", "Анна", 21);
        KickScooter scooter = new KickScooter("-", "Micro", "Flex", "MS987654", "Игорь");

        List<Vehicle> vehicles = List.of(car, motorcycle, quad, bicycle, scooter);
        LocalDate today = LocalDate.now();

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle + ", владелец " + vehicle.getOwner() + ", привод " + vehicle.getDriveType());
            vehicle.service();
            if (vehicle instanceof Refuelable refuelable) {
                refuelable.refuel(10);
                System.out.println("  топлива: " + refuelable.getFuelLevel());
            }
            if (vehicle.requiresInspection()) {
                vehicle.passInspection(today);
            }
        }

        car.setOwner("Иванов");
        car.repair();
        System.out.println("Новый владелец: " + car.getOwner());
        System.out.println("Коробка 300 л в багажнике: " + car.fitsInTrunk(300));

        motorcycle.attachSidecar();
        System.out.println("Коляска: " + motorcycle.isSidecarAttached());

        quad.switchAllWheelDrive(true);
        System.out.println("Полный привод: " + quad.isAllWheelDrive());

        bicycle.shiftGear(7);
        System.out.println("Передача: " + bicycle.getCurrentGear());

        scooter.fold();
        System.out.println("Самокат сложен: " + scooter.isFolded());
    }
}
