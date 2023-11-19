package ru.bstu.course.mashurov.bank.entity;

import java.util.Date;

public class PaymentAccount {

    private Integer id;

    private User user;

    private String bankName;

    private Integer sum;

    public PaymentAccount(Integer id, User user, String bankName) {

        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.sum = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", sum=" + sum +
                '}';
    }
}
