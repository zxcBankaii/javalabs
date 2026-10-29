package com.epam.training.chapter3.varianta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PhoneDirectory {

    private final Phone[] phones;

    public PhoneDirectory(Phone... phones) {
        this.phones = phones.clone();
    }

    public List<Phone> withCityCallsLongerThan(int minutes) {
        return Arrays.stream(phones)
                .filter(phone -> phone.getCityCallMinutes() > minutes)
                .toList();
    }

    public List<Phone> withIntercityCalls() {
        return Arrays.stream(phones)
                .filter(phone -> phone.getIntercityCallMinutes() > 0)
                .toList();
    }

    public List<Phone> sortedByName() {
        return Arrays.stream(phones)
                .sorted(Comparator.comparing(Phone::getLastName)
                        .thenComparing(Phone::getFirstName)
                        .thenComparing(Phone::getMiddleName))
                .toList();
    }
}
