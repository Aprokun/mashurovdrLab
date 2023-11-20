package ru.bstu.course.mashurov.bank;

import ru.bstu.course.mashurov.bank.entity.*;
import ru.bstu.course.mashurov.bank.entity.values.BankAtmStatusValues;
import ru.bstu.course.mashurov.bank.service.*;
import ru.bstu.course.mashurov.bank.service.impl.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        BankService bankService = new BankServiceImpl();
        ClientService clientService = new ClientServiceImpl(bankService);

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl(bankService);
        bankService.setBankOfficeService(bankOfficeService);
        bankService.setClientService(clientService);

        bankService.setBankOfficeService(bankOfficeService);

        EmployeeService employeeService = new EmployeeServiceImpl(bankOfficeService);
        bankOfficeService.setEmployeeService(employeeService);

        AtmService atmService = new AtmServiceImpl(bankOfficeService);
        bankOfficeService.setAtmService(atmService);

        bankService.setClientService(clientService);

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl(clientService);
        CreditAccountService creditAccountService = new CreditAccountServiceImpl(clientService);

        // Создадим банки
        bankService.create(new Bank("Sbebra Bank"));
        bankService.create(new Bank("Tinkonn"));
        bankService.create(new Bank("BTV"));
        bankService.create(new Bank("Beta bank"));
        bankService.create(new Bank("Dimalegenda bank"));

        // Создание офисов в каждом банке
        List<Bank> banks = bankService.fetchAll();
        for (Bank bank : banks) {
            for (int i = 1; i <= 3; i++) {
                bankOfficeService.create(
                    new BankOffice(
                        "Office №" + i + " of " + bank.getName(), "Esenina str. " + i,
                        bank, true, true, 0, true, true,
                        true, new BigDecimal("20000"), new BigDecimal(100 * i)
                    )
                );
            }
        }

        // Добавление сотрудников в каждый офис
        List<BankOffice> offices = bankOfficeService.fetchAll();
        for (BankOffice office : offices) {
            for (int i = 1; i <= 5; i++) {
                employeeService.create(
                    new Employee(
                        Utils.getNames()[random.nextInt(Utils.getNames().length)],
                        LocalDate.of(random.nextInt(1990, 2003), random.nextInt(1, 13), random.nextInt(1, 29)),
                        Utils.getRandomEmployee(), office.getBank(), true, office, true, new BigDecimal("300")
                    )
                );
            }
        }

        // Добавление банкоматов в каждый офис
        for (BankOffice office : offices) {
            for (int i = 1; i <= 3; i++) {
                atmService.create(
                    new BankAtm(
                        "Atm " + i, office.getAddress(), BankAtmStatusValues.WORKING, office.getBank(), office,
                        bankOfficeService.getAllEmployeesByOfficeId(office.getId()).get(random.nextInt(bankOfficeService.getAllEmployeesByOfficeId(office.getId()).size())),
                        true, true, office.getTotalMoney(), BigDecimal.valueOf(random.nextDouble() * 25)
                    )
                );
            }
        }

        // Добавление клиентов в каждый банк
        for (Bank bank : banks) {
            for (int i = 1; i <= 5; i++) {
                clientService.create(
                    new Client(
                        Utils.getNames()[(random.nextInt(Utils.getNames().length))],
                        LocalDate.of(random.nextInt(200, 300), random.nextInt(1, 13), random.nextInt(1, 29)),
                        Utils.getWorkPlaces()[random.nextInt(Utils.getWorkPlaces().length)],
                        BigDecimal.valueOf(random.nextDouble() * 10000), bank, new BigDecimal(random.nextInt(10000))
                    )
                );
            }
        }

        // Добавление платежных счетов каждому клиенту
        List<Client> clients = clientService.fetchAll();
        for (Client client : clients) {
            for (int i = 1; i <= 2; i++) {
                paymentAccountService.create(
                    new PaymentAccount(client, client.getBank(), BigDecimal.valueOf(random.nextDouble() * 10000))
                );
            }
        }

        // Добавление кредитных счетов каждому клиенту
        for (Client client : clients) {
            for (int i = 1; i <= 2; i++) {

                List<BankOffice> bankOffices = bankService.getAllOfficesByBankId(client.getBank().getId());

                BankOffice randomOffice = bankOffices.get(random.nextInt(bankOffices.size()));

                List<Employee> officeEmployees = bankOfficeService.getAllEmployeesByOfficeId(randomOffice.getId());

                Employee randomEmployee = officeEmployees.get(random.nextInt(officeEmployees.size()));

                CreditAccount creditAccount = new CreditAccount(
                    client, client.getBank(), LocalDate.of(2023, 10, 1),
                    LocalDate.of(2026, 10, 1), 36,
                    new BigDecimal("2600"), new BigDecimal("2600"), new BigDecimal("100"),
                    client.getBank().getInterestRate(), randomEmployee,
                    clientService.getAllPaymentAccountsByClientId(client.getId()).get(random.nextInt(clientService.getAllPaymentAccountsByClientId(client.getId()).size()))
                );

                creditAccountService.create(creditAccount);
            }
        }

        System.out.println("\nLab #2.");

        label:
        while (true) {

            System.out.println("\nPick an action: ");
            System.out.println("b - check bank data by bank id");
            System.out.println("c - check client data by client id");
            System.out.println("t - take credit");
            System.out.println("q - quit program");

            String action = scanner.nextLine();

            switch (action) {

                case "b":

                    System.out.println("Number of banks in the system: " + bankService.fetchAll().size());

                    for (Bank bank : bankService.fetchAll()) {
                        System.out.println("id: " + bank.getId() + " - " + bank.getName());
                    }

                    System.out.println("Enter bank id:");

                    int bankIdToPrint = scanner.nextInt();
                    scanner.nextLine();
                    bankService.printBankData(bankIdToPrint);

                    break;

                case "c":

                    System.out.println("Number of clients in the system: " + clientService.fetchAll().size());

                    for (Client client : clientService.fetchAll()) {
                        System.out.println("id: " + client.getId() + " - " + client.getName());
                    }

                    System.out.println("Enter client id:");

                    int clientIdToPrint = scanner.nextInt();
                    scanner.nextLine();
                    clientService.printClientData(clientIdToPrint, true);

                    break;

                case "t":

                    System.out.println("What client should take the credit?");

                    for (Client client : clientService.fetchAll()) {
                        System.out.println("id: " + client.getId() + " - " + client.getName());
                    }

                    System.out.println("Enter client id:");

                    int clientId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter total credit amount");
                    BigDecimal amount = new BigDecimal(scanner.nextLine());

                    System.out.println("Enter duration in months:");
                    int months = scanner.nextInt();

                    scanner.nextLine();

                    List<Bank> suitableBanks = bankService.getBanksSuitable(amount, months);

                    System.out.println("List of suitable banks:");
                    for (Bank bank : suitableBanks) {
                        System.out.println("id: " + bank.getId() + " - " + bank.getName());
                    }

                    System.out.println("Enter bank id:");
                    int bankId = scanner.nextInt();
                    scanner.nextLine();

                    Bank bank = bankService.findById(bankId);
                    BankOffice bankOffice = bankService.getBankOfficeSuitableInBank(bank, amount).get(0);
                    Employee employee = bankOfficeService.getSuitableEmployeeInOffice(bankOffice).get(0);
                    PaymentAccount paymentAccount;

                    try {
                        paymentAccount = clientService.getBestPaymentAccount(clientId);
                    } catch (Exception e) {
                        paymentAccount = paymentAccountService.create(new PaymentAccount(
                            clientService.findById(clientId),
                            clientService.findById(clientId).getBank(),
                            new BigDecimal("0")));
                    }

                    CreditAccount creditAccount = creditAccountService.create(
                        new CreditAccount(
                            clientService.findById(clientId), bank, LocalDate.now(),
                            months, amount, new BigDecimal("0"), new BigDecimal("0"),
                            employee, paymentAccount
                        )
                    );

                    if (bankService.approveCredit(bank, creditAccount, employee)) {

                        System.out.println("Credit was approved");
                        System.out.println("id: " + creditAccount.getId());

                    } else {
                        System.out.println("Credit was not approved");
                    }

                case "q":
                    break label;

                default:
                    System.out.println("Error: unknown action. Please, try again");
                    break;
            }
        }

        scanner.close();
    }
}
