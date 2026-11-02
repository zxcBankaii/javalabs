package com.epam.training.chapter6.varianta;

public class Motorcycle extends MotorVehicle {

    private boolean sidecarAttached;

    public Motorcycle(String registrationNumber, String brand, String model, String vin, String owner,
                      DriveType driveType, double tankCapacity) {
        super(registrationNumber, brand, model, vin, owner, driveType, tankCapacity);
    }

    public void attachSidecar() {
        sidecarAttached = true;
    }

    public boolean isSidecarAttached() {
        return sidecarAttached;
    }
}
