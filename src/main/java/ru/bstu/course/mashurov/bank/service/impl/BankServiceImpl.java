package ru.bstu.course.mashurov.bank.service.impl;

import ru.bstu.course.mashurov.bank.Utils;
import ru.bstu.course.mashurov.bank.entity.*;
import ru.bstu.course.mashurov.bank.validator.BankValidator;
import ru.bstu.course.mashurov.bank.service.BankOfficeService;
import ru.bstu.course.mashurov.bank.service.BankService;
import ru.bstu.course.mashurov.bank.service.ClientService;

import java.math.BigDecimal;
import java.util.*;

public class BankServiceImpl implements BankService {

    public static int currentId;
    private final Map<Integer, Bank> banks = new HashMap<>();
    private final Map<Integer, List<BankOffice>> officesByBankId = new HashMap<>();
    private final Map<Integer, List<Client>> clientsByBankId = new HashMap<>();

    private BankOfficeService bankOfficeService;
    private ClientService clientService;

    @Override
    public Bank findById(Integer id) {

        Bank bank = banks.get(id);

        if (bank == null) {
            System.err.println("Bank with id " + id + " is not found");
        }

        return bank;
    }

    @Override
    public List<Bank> fetchAll() {
        return new ArrayList<>(banks.values());
    }

    @Override
    public Bank create(Bank bank) {

        if (bank == null) {
            return null;
        }

        Bank newBank = new Bank(bank.getName());

        final Random random = new Random();

        newBank.setRating((byte) random.nextInt(Bank.MAX_RATING.intValue() + 1));
        newBank.setTotalMoney(
            Utils.between(new BigDecimal("0.0"), new BigDecimal("1.0").multiply(Bank.MAX_TOTAL_MONEY))
        );

        calculateInterestRate(newBank);

        banks.put(newBank.getId(), newBank);
        officesByBankId.put(newBank.getId(), new ArrayList<>());
        clientsByBankId.put(newBank.getId(), new ArrayList<>());

        return newBank;
    }

    @Override
    public void delete(Bank entity) {

    }

    @Override
    public void update(Bank entity) {

    }

    @Override
    public void setBankOfficeService(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
    }

    @Override
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public List<BankOffice> getAllOfficesByBankId(int id) {

        Bank bank = findById(id);

        if (bank != null) {
            return officesByBankId.get(id);
        }

        return new ArrayList<>();
    }

    @Override
    public void printBankData(int bankId) {

        Bank bank = findById(bankId);

        if (bank == null) {
            return;
        }

        System.out.println("=====================");
        System.out.println(bank);

        List<BankOffice> offices = officesByBankId.get(bankId);

        if (offices != null) {
            System.out.println("Offices:");
            offices.forEach((BankOffice office) -> bankOfficeService.printBankOfficeData(office.getId()));
        }

        List<Client> clients = clientsByBankId.get(bankId);

        if (clients != null) {
            System.out.println("Clients:");
            clients.forEach((Client client) -> {
                clientService.printClientData(client.getId(), false);
            });
        }

        System.out.println("=====================");
    }

    @Override
    public boolean addOffice(int bankId, BankOffice bankOffice) {
        Bank bank = findById(bankId);
        if (bank != null && bankOffice != null) {
            bankOffice.setBank(bank);
            bank.setOfficeCount(bank.getOfficeCount() + 1);
            bank.setAtmCount(bank.getAtmCount() + bankOffice.getAtmCount());
            depositMoney(bankId, bankOffice.getTotalMoney());
            List<BankOffice> bankOffices = getAllOfficesByBankId(bankId);
            bankOffices.add(bankOffice);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeOffice(int bankId, BankOffice bankOffice) {

        Bank bank = findById(bankId);

        int officeIndex = officesByBankId.get(bankId).indexOf(bankOffice);

        if (bank != null && officeIndex >= 0) {

            final int newOfficeCount = bank.getOfficeCount() - 1;

            if (newOfficeCount < 0) {
                System.err.println("Error: Bank - cannot remove office, no offices");
                return false;
            }

            bank.setOfficeCount(newOfficeCount);

            bank.setAtmCount(bank.getAtmCount() - officesByBankId.get(bankId).get(officeIndex).getAtmCount());
            officesByBankId.get(bankId).remove(officeIndex);

            return true;
        }

        return false;
    }

    @Override
    public boolean addEmployee(Bank bank, Employee employee) {

        if (bank != null && employee != null) {
            employee.setBank(bank);
            bank.setEmployeeCount(bank.getEmployeeCount() + 1);
            return true;
        }

        return false;
    }

    @Override
    public boolean removeEmployee(Bank bank, Employee employee) {

        if (bank != null && employee != null) {

            final int newEmployeeCount = bank.getEmployeeCount() - 1;

            if (newEmployeeCount < 0) {
                System.err.println("Error: Bank - cannot remove employee, no employees");
                return false;
            }

            bank.setEmployeeCount(newEmployeeCount);

            return true;
        }

        return false;
    }

    @Override
    public boolean addClient(int id, Client client) {

        Bank bank = findById(id);

        if (bank != null && client != null) {

            client.setBank(bank);
            bank.setClientCount(bank.getClientCount() + 1);

            List<Client> clients = clientsByBankId.get(id);
            clients.add(client);

            return true;
        }

        return false;
    }

    @Override
    public boolean removeClient(Bank bank, Client client) {

        if (bank != null && client != null) {

            int newClientCount = bank.getClientCount() - 1;

            if (newClientCount < 0) {
                System.err.println("Error: Bank - cannot remove client, no clients");
                return false;
            }

            bank.setClientCount(newClientCount);

            return true;
        }

        return false;
    }

    @Override
    public BigDecimal calculateInterestRate(Bank bank) {

        if (bank != null) {

            final BigDecimal rating = BigDecimal.valueOf(bank.getRating());

            final BigDecimal centralBankInterestRate = Utils
                .between(new BigDecimal("0.0"), new BigDecimal("1.0"))
                .multiply(Bank.MAX_INTEREST_RATE);

            final BigDecimal maxBankInterestRateMargin = Bank.MAX_INTEREST_RATE.subtract(centralBankInterestRate);

            final BigDecimal bankInterestRateMargin = (Utils.between(new BigDecimal("0.0"), new BigDecimal("1.0"))
                .multiply(maxBankInterestRateMargin))
                .multiply((new BigDecimal("110").subtract(rating).divide(new BigDecimal("100"))));

            final BigDecimal interestRate = centralBankInterestRate.add(bankInterestRateMargin);

            bank.setInterestRate(interestRate);

            return interestRate;
        }

        return new BigDecimal("0");
    }

    @Override
    public boolean depositMoney(int id, BigDecimal amount) {

        Bank bank = findById(id);

        if (BankValidator.validateDepositMoney(amount, bank)) return false;

        bank.setTotalMoney(bank.getTotalMoney().add(amount));
        return true;
    }

    @Override
    public boolean withdrawMoney(int id, BigDecimal amount) {

        Bank bank = findById(id);

        if (BankValidator.validateWithdrawMoney(amount, bank)) return false;

        bank.setTotalMoney(bank.getTotalMoney().subtract(amount));

        return true;
    }

    @Override
    public boolean approveCredit(Bank bank, CreditAccount account, Employee employee) {
        return false;
    }

    @Override
    public List<Bank> getBanksSuitable(BigDecimal sum, int countMonth) throws Exception {

        List<Bank> banksSuitable = new ArrayList<>();

        for (Bank bank : banks.values()) {
            if (isBankSuitable(bank, sum)) {
                banksSuitable.add(bank);
            }
        }

        if (banksSuitable.isEmpty()) {
            throw new Exception("Error: can't give credit");
        }

        return banksSuitable;
    }

    @Override
    public boolean isBankSuitable(Bank bank, BigDecimal money) throws Exception {
        List<BankOffice> bankOfficeSuitable = getBankOfficeSuitableInBank(bank, money);
        return !bankOfficeSuitable.isEmpty();
    }

    @Override
    public List<BankOffice> getBankOfficeSuitableInBank(Bank bank, BigDecimal money) throws Exception {
        List<BankOffice> bankOfficesByBank = getAllOfficesByBankId(bank.getId());
        List<BankOffice> suitableBankOffice = new ArrayList<>();

        for (BankOffice bankOffice : bankOfficesByBank) {
            if (bankOfficeService.isSuitableBankOffice(bankOffice, money)) {
                suitableBankOffice.add(bankOffice);
            }
        }

        return suitableBankOffice;
    }
}
