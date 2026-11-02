package com.epam.training.chapter6.varianta;

public class Quad extends MotorVehicle {

    private boolean allWheelDrive;

    public Quad(String registrationNumber, String brand, String model, String vin, String owner,
                DriveType driveType, double tankCapacity) {
        super(registrationNumber, brand, model, vin, owner, driveType, tankCapacity);
    }

    public void switchAllWheelDrive(boolean enabled) {
        allWheelDrive = enabled;
    }

    public boolean isAllWheelDrive() {
        return allWheelDrive;
    }
}
