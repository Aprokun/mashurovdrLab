package ru.bstu.course.mashurov.bank.entity;

import ru.bstu.course.mashurov.bank.service.impl.BankServiceImpl;

import java.math.BigDecimal;

public class Bank {

    private int id;
    private String name;
    private int officeCount;
    private int atmCount;
    private int employeeCount;
    private int clientCount;
    private byte rating;
    private BigDecimal totalMoney;
    private BigDecimal interestRate;

    public Bank() {

        initId();

        this.id = UUID.randomUUID();
        this.name = "No name";
        this.officeCount = 0;
        this.atmCount = 0;
        this.employeeCount = 0;
        this.clientCount = 0;
        this.rating = 0;
        this.totalMoney = new BigDecimal("0");
        this.interestRate = new BigDecimal("0");
    }

    private void initId() {
        id = BankServiceImpl.currentId++;
    }

    public Bank(Bank bank) {

        this.id = bank.id;
        this.name = bank.name;
        this.officeCount = bank.officeCount;
        this.atmCount = bank.atmCount;
        this.employeeCount = bank.employeeCount;
        this.clientCount = bank.clientCount;
        this.rating = bank.rating;
        this.totalMoney = bank.totalMoney;
        this.interestRate = bank.interestRate;
    }

    public Bank(String name) {

        initId();

        this.officeCount = 0;
        this.atmCount = 0;
        this.employeeCount = 0;
        this.clientCount = 0;
        this.rating = 0;
        this.totalMoney = new BigDecimal("0");
        this.interestRate = new BigDecimal("0");
        this.name = name;
    }

    public Bank(int id, String name) {

        this.officeCount = 0;
        this.atmCount = 0;
        this.employeeCount = 0;
        this.clientCount = 0;
        this.rating = 0;
        this.totalMoney = new BigDecimal("0");
        this.interestRate = new BigDecimal("0");
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {

        return """
            Bank:{
                id='%s',
                name='%s',
                officeCount='%s',
                atmCount='%s',
                employeeCount='%s',
                clientCount='%s',
                rating='%s',
                totalMoney='%.2f',
                interestRate='%.2f'
            }
            """
            .formatted(
                getId(), getName(), getOfficeCount(), getAtmCount(), getEmployeeCount(),
                getClientCount(), getRating(), getTotalMoney(), getInterestRate()
            );
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOfficeCount() {
        return this.officeCount;
    }

    public void setOfficeCount(int officeCount) {
        this.officeCount = officeCount;
    }

    public int getAtmCount() {
        return this.atmCount;
    }

    public void setAtmCount(int atmCount) {
        this.atmCount = atmCount;
    }

    public int getEmployeeCount() {
        return this.employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getClientCount() {
        return this.clientCount;
    }

    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }

    public byte getRating() {
        return this.rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public BigDecimal getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    private void initWithDefaults() {

        name = "No name";
        officeCount = 0;
        atmCount = 0;
        employeeCount = 0;
        clientCount = 0;
        rating = 0;
        totalMoney = new BigDecimal("0");
        interestRate = new BigDecimal("0");
    }

}
