package ru.bstu.course.mashurov.bank.entity;

import java.util.Date;

public class Employee {

    private Integer id;

    private String fullName;

    private Date birthDate;

    private String post;

    private Bank bank;

    private boolean isRemoteWorking;

    private BankOffice bankOffice;

    private boolean isCanIssueLoan;

    private Integer salary;

    public Employee(
            Integer id, String fullName, Date birthDate, String post, Bank bank, boolean isRemoteWorking,
            BankOffice bankOffice, boolean isCanIssueLoan, Integer salary
    ) {

        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.post = post;
        this.bank = bank;
        this.isRemoteWorking = isRemoteWorking;
        this.bankOffice = bankOffice;
        this.isCanIssueLoan = isCanIssueLoan;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public boolean isRemoteWorking() {
        return isRemoteWorking;
    }

    public void setRemoteWorking(boolean remoteWorking) {
        isRemoteWorking = remoteWorking;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public boolean isCanIssueLoan() {
        return isCanIssueLoan;
    }

    public void setCanIssueLoan(boolean canIssueLoan) {
        isCanIssueLoan = canIssueLoan;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", post='" + post + '\'' +
                ", bank=" + bank +
                ", isRemoteWorking=" + isRemoteWorking +
                ", bankOffice=" + bankOffice +
                ", isCanIssueLoan=" + isCanIssueLoan +
                ", salary=" + salary +
                '}';
    }
}
