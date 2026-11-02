package com.epam.training.chapter6.varianta;

public class Car extends MotorVehicle {

    private final int trunkCapacityLiters;

    public Car(String registrationNumber, String brand, String model, String vin, String owner,
               DriveType driveType, double tankCapacity, int trunkCapacityLiters) {
        super(registrationNumber, brand, model, vin, owner, driveType, tankCapacity);
        this.trunkCapacityLiters = trunkCapacityLiters;
    }

    public boolean fitsInTrunk(int liters) {
        return liters <= trunkCapacityLiters;
    }
}
