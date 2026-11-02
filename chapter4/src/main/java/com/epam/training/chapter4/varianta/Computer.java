package com.epam.training.chapter4.varianta;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Computer {

    private static final Set<String> VIRUS_SIGNATURES = Set.of("trojan.exe", "worm.dll");

    private final HardDrive hardDrive;
    private final DiskDrive diskDrive;
    private final Ram ram;
    private final Processor processor;
    private boolean turnedOn;

    public Computer(HardDrive hardDrive, DiskDrive diskDrive, Ram ram, Processor processor) {
        this.hardDrive = hardDrive;
        this.diskDrive = diskDrive;
        this.ram = ram;
        this.processor = processor;
    }

    public void turnOn() {
        turnedOn = true;
        System.out.println("Компьютер включён");
    }

    public void turnOff() {
        turnedOn = false;
        System.out.println("Компьютер выключен");
    }

    public List<String> scanForViruses() {
        if (!turnedOn) {
            throw new IllegalStateException("Компьютер выключен");
        }
        return hardDrive.files().stream()
                .filter(VIRUS_SIGNATURES::contains)
                .toList();
    }

    public void printHardDriveSize() {
        System.out.println("Размер винчестера: " + hardDrive.capacityGb() + " ГБ");
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Computer other
                && hardDrive.equals(other.hardDrive)
                && diskDrive.equals(other.diskDrive)
                && ram.equals(other.ram)
                && processor.equals(other.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hardDrive, diskDrive, ram, processor);
    }

    @Override
    public String toString() {
        return "Computer[" + processor + ", " + ram + ", " + hardDrive + ", " + diskDrive + "]";
    }
}
