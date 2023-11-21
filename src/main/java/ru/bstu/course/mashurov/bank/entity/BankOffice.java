package ru.bstu.course.mashurov.bank.entity;

import ru.bstu.course.mashurov.bank.service.impl.BankOfficeServiceImpl;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankOffice {

    private int id;
    private String name;
    private String address;
    private Bank bank;
    private boolean isWorking;
    private boolean isAtmPlaceable;
    private int atmCount;
    private boolean isCreditAvailable;
    private boolean isCashWithdrawalAvailable;
    private boolean isCashDepositAvailable;
    private BigDecimal totalMoney;
    private BigDecimal rentPrice;

    private void initId() {
        id = BankOfficeServiceImpl.currentId++;
    }

    public BankOffice(String name, String address) {

        initId();
        initWithDefaults();

        this.name = name;
        this.address = address;
    }

    public BankOffice(
        int id, String name, String address, Bank bank, boolean isWorking, boolean isAtmPlaceable,
        int atmCount, boolean isCreditAvailable, boolean isCashWithdrawalAvailable, boolean isCashDepositAvailable,
        BigDecimal totalMoney, BigDecimal rentPrice
    ) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.bank = bank;
        this.isWorking = isWorking;
        this.isAtmPlaceable = isAtmPlaceable;
        this.atmCount = atmCount;
        this.isCreditAvailable = isCreditAvailable;
        this.isCashWithdrawalAvailable = isCashWithdrawalAvailable;
        this.isCashDepositAvailable = isCashDepositAvailable;
        this.totalMoney = totalMoney;
        this.rentPrice = rentPrice;
    }

    public BankOffice(
        String name, String address, Bank bank, boolean isWorking, boolean isAtmPlaceable,
        int atmCount, boolean isCreditAvailable, boolean isCashWithdrawalAvailable, boolean isCashDepositAvailable,
        BigDecimal totalMoney, BigDecimal rentPrice
    ) {

        initId();
        initWithDefaults();

        this.name = name;
        this.address = address;
        this.bank = bank;
        this.isWorking = isWorking;
        this.isAtmPlaceable = isAtmPlaceable;
        this.atmCount = atmCount;
        this.isCreditAvailable = isCreditAvailable;
        this.isCashWithdrawalAvailable = isCashWithdrawalAvailable;
        this.isCashDepositAvailable = isCashDepositAvailable;
        this.totalMoney = totalMoney;
        this.rentPrice = rentPrice;
    }

    public BankOffice(BankOffice bankOffice) {

        this.id = bankOffice.id;
        this.name = bankOffice.name;
        this.address = bankOffice.address;
        this.bank = new Bank(bankOffice.bank);
        this.isWorking = bankOffice.isWorking;
        this.isAtmPlaceable = bankOffice.isAtmPlaceable;
        this.atmCount = bankOffice.atmCount;
        this.isCreditAvailable = bankOffice.isCreditAvailable;
        this.isCashWithdrawalAvailable = bankOffice.isCashWithdrawalAvailable;
        this.isCashDepositAvailable = bankOffice.isCashDepositAvailable;
        this.totalMoney = bankOffice.totalMoney;
        this.rentPrice = bankOffice.rentPrice;
    }

    @Override
    public String toString() {

        return """
            BankOffice:{
                id='%s',
                name='%s',
                address='%s',
                bank='%s',
                isWorking='%s',
                isAtmPlaceable='%s',
                atmCount='%s',
                isCreditAvailable='%s',
                isCashWithdrawalAvailable='%s',
                isCashDepositAvailable='%s',
                totalMoney='%.2f',
                rentPrice='%.2f'
            }
            """
            .formatted(
                getId(), getName(), getAddress(), getBank().getName(), isIsWorking(), isIsAtmPlaceable(),
                getAtmCount(), isIsCreditAvailable(), isIsCashWithdrawalAvailable(),
                isIsCashDepositAvailable(), getTotalMoney(), getRentPrice()
            );
    }

    private void initWithDefaults() {

        name = "No name";
        address = "No address";
        bank = null;
        isWorking = false;
        isAtmPlaceable = false;
        atmCount = 0;
        isCreditAvailable = false;
        isCashWithdrawalAvailable = false;
        isCashDepositAvailable = false;
        totalMoney = new BigDecimal("0");
        rentPrice = new BigDecimal("0");
    }

}