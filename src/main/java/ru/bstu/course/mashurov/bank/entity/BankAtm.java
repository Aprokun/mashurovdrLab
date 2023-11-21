package ru.bstu.course.mashurov.bank.entity;

import lombok.Data;
import ru.bstu.course.mashurov.bank.entity.values.BankAtmStatusValues;
import ru.bstu.course.mashurov.bank.service.impl.AtmServiceImpl;

import java.math.BigDecimal;

@Data
public class BankAtm {

    private int id;
    private String name;
    private String address;
    private BankAtmStatusValues status;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee employee;
    private boolean isCashWithdrawalAvailable;
    private boolean isCashDepositAvailable;
    private BigDecimal totalMoney;
    private BigDecimal maintenanceCost;

    private void initId() {
        id = AtmServiceImpl.currentId++;
    }

    public BankAtm(BankAtm bankAtm) {

        this.id = bankAtm.id;
        this.name = bankAtm.name;
        this.address = bankAtm.address;
        this.status = bankAtm.status;
        this.bank = new Bank(bankAtm.bank);
        this.bankOffice = new BankOffice(bankAtm.bankOffice);
        this.employee = new Employee(bankAtm.employee);
        this.isCashWithdrawalAvailable = bankAtm.isCashWithdrawalAvailable;
        this.isCashDepositAvailable = bankAtm.isCashDepositAvailable;
        this.totalMoney = bankAtm.totalMoney;
        this.maintenanceCost = bankAtm.maintenanceCost;
    }

    public BankAtm() {

        initId();

        this.name = "No name";
        this.address = "No address";
        this.status = BankAtmStatusValues.NOT_WORKING;
        this.bank = null;
        this.bankOffice = null;
        this.employee = null;
        this.isCashWithdrawalAvailable = false;
        this.isCashDepositAvailable = false;
        this.totalMoney = new BigDecimal("0");
        this.maintenanceCost = new BigDecimal("0");
    }

    public BankAtm(String name, String address) {

        initId();

        this.id = UUID.randomUUID();
        this.status = BankAtmStatusValues.NOT_WORKING;
        this.bank = null;
        this.bankOffice = null;
        this.employee = null;
        this.isCashWithdrawalAvailable = false;
        this.isCashDepositAvailable = false;
        this.totalMoney = new BigDecimal("0");
        this.maintenanceCost = new BigDecimal("0");
        this.name = name;
        this.address = address;
    }

    public BankAtm(
        String name, String address, BankAtmStatusValues status, Bank bank, BankOffice bankOffice,
        Employee employee, boolean isCashWithdrawalAvailable, boolean isCashDepositAvailable, BigDecimal totalMoney,
        BigDecimal maintenanceCost
    ) {

        initId();

        this.name = name;
        this.address = address;
        this.status = status;
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.employee = employee;
        this.isCashWithdrawalAvailable = isCashWithdrawalAvailable;
        this.isCashDepositAvailable = isCashDepositAvailable;
        this.totalMoney = totalMoney;
        this.maintenanceCost = maintenanceCost;
    }

    public BankAtm(
        int id, String name, String address, BankAtmStatusValues status, Bank bank, BankOffice bankOffice,
        Employee employee, boolean isCashWithdrawalAvailable, boolean isCashDepositAvailable, BigDecimal totalMoney,
        BigDecimal maintenanceCost
    ) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.employee = employee;
        this.isCashWithdrawalAvailable = isCashWithdrawalAvailable;
        this.isCashDepositAvailable = isCashDepositAvailable;
        this.totalMoney = totalMoney;
        this.maintenanceCost = maintenanceCost;
    }

    @Override
    public String toString() {

        return """
            BankAtm:{
                id='%s',
                name='%s',
                address='%s',
                status='%s',
                bank='%s',
                bankOffice='%s',
                employee='%s',
                isCashWithdrawalAvailable='%s',
                isCashDepositAvailable='%s',
                totalMoney='%.2f',
                maintenanceCost='%.2f'
            }
            """
            .formatted(
                getId(), getName(), getAddress(), getStatus(), getBank().getName(), getBankOffice(),
                getEmployee(), isIsCashWithdrawalAvailable(), isIsCashDepositAvailable(), getTotalMoney(),
                getMaintenanceCost()
            );
    }
}
