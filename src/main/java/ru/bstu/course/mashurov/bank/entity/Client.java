package ru.bstu.course.mashurov.bank.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Client extends Person {

    private String workPlace;
    private BigDecimal monthlyIncome;
    private Bank bank;
    private BigDecimal creditRating;

    public Client() {
        initWithDefaults();
    }

    public Client(Client client) {

        super(client.id, client.name, client.birthdDate);

        this.workPlace = client.workPlace;
        this.monthlyIncome = client.monthlyIncome;
        this.bank = new Bank(client.bank);
        this.creditRating = client.creditRating;
    }

    public Client(
        String name, LocalDate birthDate, String workPlace, BigDecimal monthlyIncome, Bank bank, BigDecimal creditRating
    ) {

        super(name, birthDate);

        initWithDefaults();

        this.name = name;
        this.birthdDate = birthDate;
        this.workPlace = workPlace;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.creditRating = creditRating;
    }

    public Client(
        int id, String name, LocalDate birthDate, String workPlace, BigDecimal monthlyIncome, Bank bank,
        BigDecimal creditRating
    ) {

        super(id, name, birthDate);

        this.workPlace = workPlace;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {

        return """
            Client:{
                person='%s',
                placeOfWork='%s',
                monthlyIncome='%.2f',
                bank='%s',
                creditRating='%.2f'
            }
            """.formatted(super.toString(), getWorkPlace(), getMonthlyIncome(), getBank().getName(), getCreditRating());
    }

    public String getWorkPlace() {
        return this.workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public BigDecimal getMonthlyIncome() {
        return this.monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Bank getBank() {
        return this.bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BigDecimal getCreditRating() {
        return this.creditRating;
    }

    public void setCreditRating(BigDecimal creditRating) {
        this.creditRating = creditRating;
    }

    private void initWithDefaults() {

        workPlace = "No place of work";
        monthlyIncome = new BigDecimal("0");
        bank = null;
        creditRating = new BigDecimal("0");
    }

}