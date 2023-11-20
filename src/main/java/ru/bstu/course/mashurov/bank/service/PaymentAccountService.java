package ru.bstu.course.mashurov.bank.service;

import ru.bstu.course.mashurov.bank.entity.PaymentAccount;

import java.math.BigDecimal;

public interface PaymentAccountService extends Crud<PaymentAccount> {

    boolean depositMoney(PaymentAccount paymentAccount, BigDecimal amount);

    boolean withdrawMoney(PaymentAccount paymentAccount, BigDecimal amount);
}
