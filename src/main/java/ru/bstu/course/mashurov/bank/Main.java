package ru.bstu.course.mashurov.bank;

import ru.bstu.course.mashurov.bank.entity.*;
import ru.bstu.course.mashurov.bank.entity.values.BankAtmStatusValues;
import ru.bstu.course.mashurov.bank.entity.values.BankOfficeStatusValues;
import ru.bstu.course.mashurov.bank.entity.values.EmployeePostValues;
import ru.bstu.course.mashurov.bank.service.*;
import ru.bstu.course.mashurov.bank.service.impl.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        BankService bankService = new BankServiceImpl();
        Bank bank = bankService.create(new Bank("Sbebra bank"));
        System.out.println(bank);

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        BankOffice bankOffice = bankOfficeService.create(new BankOffice(
                "Sbebra Bank Office",
                "Free City of Braavos",
                bank,
                true,
                true,
                0,
                true,
                true,
                true,
                bank.getTotalMoney(),
                new BigDecimal("700")));
        System.out.println(bankOffice);

        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService
                .create(new Employee("Tycho Nestoris", LocalDate.of(270, 2, 21), EmployeePostValues.OFFICE_EMPLOYEE, bank, true,
                        bankOffice, true, new BigDecimal("10")));
        System.out.println(employee);

        AtmService atmService = new AtmServiceImpl();
        BankAtm bankAtm = atmService.create(new BankAtm("First ATM of Braavos", bankOffice.getAddress(), BankAtmStatusValues.WORKING, bank,
                bankOffice, employee, true, true, new BigDecimal("0"), new BigDecimal("25")));
        System.out.println(bankAtm);

        ClientService userService = new ClientServiceImpl();
        Client user = userService
                .create(
                        new Client(
                                "Stannis Baratheon", LocalDate.of(264, 2, 15),
                                "Dragon Stone", new BigDecimal("1000"), bank, new BigDecimal("999999999")
                        )
                );
        System.out.println(user);

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount paymentAccount = paymentAccountService
                .create(new PaymentAccount(user, bank, new BigDecimal("9000")));
        System.out.println(paymentAccount);

        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        CreditAccount creditAccount = creditAccountService.create(new CreditAccount(user, bank,
                LocalDate.of(298, 1, 1), LocalDate.of(302, 1, 1), 48, new BigDecimal("29000"),
                new BigDecimal("29000"),
                new BigDecimal("100"), new BigDecimal("2"), employee, paymentAccount));

        System.out.println(creditAccount);
    }
}
