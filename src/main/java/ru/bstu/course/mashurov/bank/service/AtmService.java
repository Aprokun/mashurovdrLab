package ru.bstu.course.mashurov.bank.service;

import ru.bstu.course.mashurov.bank.entity.BankAtm;

import java.math.BigDecimal;

public interface AtmService extends Crud<BankAtm> {

    boolean depositMoney(BankAtm bankAtm, BigDecimal amount);

    boolean withdrawMoney(BankAtm bankAtm, BigDecimal amount);
}
