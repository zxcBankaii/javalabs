package com.epam.training.chapter1.varianta;

public class Greeting {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Передайте имя аргументом командной строки");
            return;
        }
        System.out.println("Привет, " + String.join(" ", args) + "!");
    }
}
