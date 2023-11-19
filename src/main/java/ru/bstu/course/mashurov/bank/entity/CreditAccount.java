package ru.bstu.course.mashurov.bank.entity;

import java.time.LocalDate;
import java.util.Date;

public class CreditAccount {

    private Integer id;

    private User user;

    private String bankName;

    private Date startDate;

    private Date endDate;

    private Integer monthOfCreditCount;

    private Integer creditSum;

    private Integer monthlyPay;

    private Double percentage;

    private Employee employee;

    private PaymentAccount paymentAccount;

    public CreditAccount(
            Integer id, User user, String bankName, Date startDate, Date endDate, Integer monthOfCreditCount,
            Integer creditSum, Integer monthlyPay, Double percentage, Employee employee, PaymentAccount paymentAccount
    ) {

        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthOfCreditCount = monthOfCreditCount;
        this.creditSum = creditSum;
        this.monthlyPay = monthlyPay;
        this.percentage = percentage;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMonthOfCreditCount() {
        return monthOfCreditCount;
    }

    public void setMonthOfCreditCount(Integer monthOfCreditCount) {
        this.monthOfCreditCount = monthOfCreditCount;
    }

    public Integer getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(Integer creditSum) {
        this.creditSum = creditSum;
    }

    public Integer getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(Integer monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + id +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", monthOfCreditCount=" + monthOfCreditCount +
                ", creditSum=" + creditSum +
                ", monthlyPay=" + monthlyPay +
                ", percentage=" + percentage +
                ", employee=" + employee +
                ", paymentAccount=" + paymentAccount +
                '}';
    }
}
