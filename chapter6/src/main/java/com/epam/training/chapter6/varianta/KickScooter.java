package com.epam.training.chapter6.varianta;

public class KickScooter extends AbstractVehicle {

    private boolean folded;

    public KickScooter(String registrationNumber, String brand, String model, String vin, String owner) {
        super(registrationNumber, brand, model, vin, owner, DriveType.MUSCLE);
    }

    public void fold() {
        folded = true;
    }

    public boolean isFolded() {
        return folded;
    }

    @Override
    public boolean requiresInspection() {
        return false;
    }
}
