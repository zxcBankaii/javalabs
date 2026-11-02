package com.epam.training.chapter4.varianta;

import java.util.List;

public class ComputerApp {

    public static void main(String[] args) {
        Computer computer = new Computer(
                new HardDrive("Seagate Barracuda", 1000, List.of("report.docx", "trojan.exe", "photo.png")),
                new DiskDrive("LG GH24", "DVD"),
                new Ram(16, 3200),
                new Processor("Intel Core i5", 6));

        System.out.println(computer);
        computer.printHardDriveSize();

        try {
            computer.scanForViruses();
        } catch (IllegalStateException e) {
            System.out.println("Проверка не запущена: " + e.getMessage());
        }

        computer.turnOn();
        System.out.println("Найдены вирусы: " + computer.scanForViruses());
        computer.turnOff();
    }
}
