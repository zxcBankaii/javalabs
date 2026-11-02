package com.epam.training.chapter6.varianta;

import java.time.LocalDate;

public interface Vehicle {

    String getRegistrationNumber();

    void setRegistrationNumber(String registrationNumber);

    String getBrand();

    String getModel();

    String getVin();

    String getOwner();

    void setOwner(String owner);

    DriveType getDriveType();

    void repair();

    void service();

    void passInspection(LocalDate date);

    default boolean requiresInspection() {
        return true;
    }
}
