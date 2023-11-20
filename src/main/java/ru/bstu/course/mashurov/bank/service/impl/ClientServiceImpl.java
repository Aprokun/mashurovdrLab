package ru.bstu.course.mashurov.bank.service.impl;

import ru.bstu.course.mashurov.bank.Utils;
import ru.bstu.course.mashurov.bank.entity.Client;
import ru.bstu.course.mashurov.bank.entity.CreditAccount;
import ru.bstu.course.mashurov.bank.entity.PaymentAccount;
import ru.bstu.course.mashurov.bank.validator.ClientValidator;
import ru.bstu.course.mashurov.bank.service.BankService;
import ru.bstu.course.mashurov.bank.service.ClientService;

import java.math.BigDecimal;
import java.util.*;

public class ClientServiceImpl implements ClientService {

    private final Map<Integer, Client> clients = new HashMap<>();
    private final Map<Integer, List<PaymentAccount>> paymentAccountsByClientId = new HashMap<>();
    private final Map<Integer, List<CreditAccount>> creditAccountsByClientId = new HashMap<>();

    private final BankService bankService;

    public ClientServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public Client findById(Integer id) {

        Client client = clients.get(id);

        if (client == null) {
            System.err.println("Client with id " + id + " is not found");
        }

        return client;
    }

    @Override
    public List<Client> fetchAll() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public Client create(Client client) {

        if (ClientValidator.validateCreate(client)) return null;

        Client createdClient = new Client(client);

        final BigDecimal monthlyIncome = Utils
                .between(new BigDecimal("0.0"), new BigDecimal("1.0"))
                .multiply(Client.MAX_MONTHLY_INCOME);

        createdClient.setMonthlyIncome(monthlyIncome);

        calculateCreditRating(createdClient);

        clients.put(createdClient.getId(), createdClient);
        paymentAccountsByClientId.put(createdClient.getId(), new ArrayList<>());
        creditAccountsByClientId.put(createdClient.getId(), new ArrayList<>());
        bankService.addClient(client.getBank().getId(), createdClient);

        return createdClient;
    }

    @Override
    public void delete(Client entity) {

    }

    @Override
    public void update(Client entity) {

    }

    @Override
    public boolean addPaymentAccount(int id, PaymentAccount account) {

        Client client = clients.get(id);

        if (client != null) {

            List<PaymentAccount> clientCreditAccounts = paymentAccountsByClientId.get(id);
            clientCreditAccounts.add(account);

            return true;
        }

        return false;
    }

    @Override
    public boolean addCreditAccount(int id, CreditAccount account) {

        Client client = clients.get(id);

        if (client != null) {

            List<CreditAccount> clientCreditAccounts = creditAccountsByClientId.get(id);
            clientCreditAccounts.add(account);

            return true;
        }

        return false;
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccountsByClientId(int id) {
        return paymentAccountsByClientId.get(id);
    }

    @Override
    public List<CreditAccount> getAllCreditAccountsByClientId(int id) {
        return creditAccountsByClientId.get(id);
    }

    @Override
    public BigDecimal calculateCreditRating(Client client) {

        client.setCreditRating(
                client.getMonthlyIncome().divide(new BigDecimal("1000").multiply(new BigDecimal("100")))
        );

        return client.getCreditRating();
    }

    @Override
    public void printClientData(int id, boolean withAccounts) {

        Client client = findById(id);

        if (client == null) {
            return;
        }

        System.out.println(client);

        if (withAccounts) {

            List<PaymentAccount> paymentAccounts = getAllPaymentAccountsByClientId(id);

            if (paymentAccounts != null) {

                System.out.println("Payment accounts:");
                paymentAccounts.forEach(System.out::println);
            }

            List<CreditAccount> creditAccounts = getAllCreditAccountsByClientId(id);

            if (creditAccounts != null) {

                System.out.println("Credit accounts:");
                creditAccounts.forEach(System.out::println);
            }
        }
    }

    @Override
    public PaymentAccount getBestPaymentAccount(int id) throws Exception {

        return getAllPaymentAccountsByClientId(id)
            .stream()
            .min(Comparator.comparing(PaymentAccount::getBalance))
            .orElseThrow(Exception::new);
    }
}
