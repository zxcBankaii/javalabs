package com.epam.training.chapter6.varianta;

public class Bicycle extends AbstractVehicle {

    private final int gears;
    private int currentGear = 1;

    public Bicycle(String registrationNumber, String brand, String model, String vin, String owner, int gears) {
        super(registrationNumber, brand, model, vin, owner, DriveType.MUSCLE);
        this.gears = gears;
    }

    public void shiftGear(int gear) {
        if (gear < 1 || gear > gears) {
            throw new IllegalArgumentException("Нет передачи " + gear);
        }
        currentGear = gear;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    @Override
    public boolean requiresInspection() {
        return false;
    }
}
