package ru.bstu.course.mashurov.bank.service.impl;

import ru.bstu.course.mashurov.bank.entity.PaymentAccount;
import ru.bstu.course.mashurov.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    @Override
    public PaymentAccount findOne(Integer id) {
        return null;
    }

    @Override
    public PaymentAccount create(PaymentAccount entity) {
        return entity;
    }

    @Override
    public void delete(PaymentAccount entity) {

    }

    @Override
    public void update(PaymentAccount entity) {

    }
}
