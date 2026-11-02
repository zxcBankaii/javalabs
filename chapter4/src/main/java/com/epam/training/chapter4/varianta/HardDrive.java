package com.epam.training.chapter4.varianta;

import java.util.List;

public record HardDrive(String model, int capacityGb, List<String> files) {

    public HardDrive {
        files = List.copyOf(files);
    }
}
