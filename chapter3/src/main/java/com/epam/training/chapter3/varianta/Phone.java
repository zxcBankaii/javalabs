package com.epam.training.chapter3.varianta;

import java.math.BigDecimal;

public class Phone {

    private long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String cardNumber;
    private BigDecimal debit = BigDecimal.ZERO;
    private BigDecimal credit = BigDecimal.ZERO;
    private int cityCallMinutes;
    private int intercityCallMinutes;

    public Phone() {
    }

    public Phone(long id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Phone(long id, String lastName, String firstName, String middleName, String address,
                 String cardNumber, BigDecimal debit, BigDecimal credit,
                 int cityCallMinutes, int intercityCallMinutes) {
        this(id, lastName, firstName, middleName);
        this.address = address;
        this.cardNumber = cardNumber;
        this.debit = debit;
        this.credit = credit;
        this.cityCallMinutes = cityCallMinutes;
        this.intercityCallMinutes = intercityCallMinutes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public int getCityCallMinutes() {
        return cityCallMinutes;
    }

    public void setCityCallMinutes(int cityCallMinutes) {
        this.cityCallMinutes = cityCallMinutes;
    }

    public int getIntercityCallMinutes() {
        return intercityCallMinutes;
    }

    public void setIntercityCallMinutes(int intercityCallMinutes) {
        this.intercityCallMinutes = intercityCallMinutes;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    @Override
    public String toString() {
        return String.format("#%d %s, %s, карта %s, дебет %s, кредит %s, город %d мин, межгород %d мин",
                id, getFullName(), address, cardNumber, debit, credit, cityCallMinutes, intercityCallMinutes);
    }
}
