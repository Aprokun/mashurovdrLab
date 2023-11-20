package ru.bstu.course.mashurov.bank.service;

import ru.bstu.course.mashurov.bank.entity.CreditAccount;

public interface CreditAccountService extends Crud<CreditAccount> {

    boolean makeMonthlyPayment(CreditAccount creditAccount);
}
