package com.epam.training.chapter6.varianta;

public abstract class MotorVehicle extends AbstractVehicle implements Refuelable {

    private final double tankCapacity;
    private double fuelLevel;

    protected MotorVehicle(String registrationNumber, String brand, String model, String vin,
                           String owner, DriveType driveType, double tankCapacity) {
        super(registrationNumber, brand, model, vin, owner, driveType);
        this.tankCapacity = tankCapacity;
    }

    @Override
    public void refuel(double amount) {
        if (amount <= 0 || fuelLevel + amount > tankCapacity) {
            throw new IllegalArgumentException("Нельзя заправить " + amount + ", бак " + tankCapacity);
        }
        fuelLevel += amount;
    }

    @Override
    public double getFuelLevel() {
        return fuelLevel;
    }
}
