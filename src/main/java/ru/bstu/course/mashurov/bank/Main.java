package ru.bstu.course.mashurov.bank;

import ru.bstu.course.mashurov.bank.entity.*;
import ru.bstu.course.mashurov.bank.entity.values.BankAtmStatusValues;
import ru.bstu.course.mashurov.bank.entity.values.BankOfficeStatusValues;
import ru.bstu.course.mashurov.bank.entity.values.EmployeePostValues;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank(1, "Bebra bank");

        BankAtm bankAtm = new BankAtm(
                1, "atm", "address1", BankAtmStatusValues.WORKING,
                "hall", "Ivanov Ivan Ivanovich", true, true,
                bank.getTotalMoney(), 20000
        );

        BankOffice bankOffice = new BankOffice(
                1, "bebra bank office", "address2", BankOfficeStatusValues.WORKING, true,
                0, true, true, true, bank.getTotalMoney(), 300000
        );

        Employee employee = new Employee(
                1, "Petrov Petr Petrovich", new Date(), EmployeePostValues.DIRECTOR, bank, false, bankOffice, false, 300000
        );

        User user = new User(
                1, "Ya Polzovatel Banka", new Date(), "Some workplace", 30000
        );

        PaymentAccount paymentAccount = new PaymentAccount(1, user, bank.getName());

        CreditAccount creditAccount = new CreditAccount(
                1, user, bank.getName(), new Date(1637324288), new Date(1700396288), 24,
                3000000, 30000, bank.getPercentage(), employee, paymentAccount
        );

        System.out.println("Bank - " + bank);
        System.out.println("Bank office - " + bankOffice);
        System.out.println("Bank atm - " + bankAtm);
        System.out.println("Employee - " + employee);
        System.out.println("User - " + user);
        System.out.println("Payment account - " + paymentAccount);
        System.out.println("Credit account - " + creditAccount);
    }
}
