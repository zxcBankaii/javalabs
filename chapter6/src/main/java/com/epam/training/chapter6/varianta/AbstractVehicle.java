package com.epam.training.chapter6.varianta;

import java.time.LocalDate;

public abstract class AbstractVehicle implements Vehicle {

    private String registrationNumber;
    private final String brand;
    private final String model;
    private final String vin;
    private String owner;
    private final DriveType driveType;
    private LocalDate lastInspection;

    protected AbstractVehicle(String registrationNumber, String brand, String model, String vin,
                              String owner, DriveType driveType) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.vin = vin;
        this.owner = owner;
        this.driveType = driveType;
    }

    @Override
    public void repair() {
        System.out.println(this + ": ремонт выполнен");
    }

    @Override
    public void service() {
        System.out.println(this + ": обслуживание выполнено");
    }

    @Override
    public void passInspection(LocalDate date) {
        if (!requiresInspection()) {
            throw new IllegalStateException(this + " не проходит техосмотр");
        }
        lastInspection = date;
        System.out.println(this + ": техосмотр пройден " + date);
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getVin() {
        return vin;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public DriveType getDriveType() {
        return driveType;
    }

    public LocalDate getLastInspection() {
        return lastInspection;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + brand + " " + model + " (" + registrationNumber + ")";
    }
}
