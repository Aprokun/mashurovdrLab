package ru.bstu.course.mashurov.bank.entity;

import static ru.bstu.course.mashurov.bank.Utils.random;

public class Bank {

    private Integer id;

    private String name;

    private Integer officeCount = 0;

    private Integer atmCount = 0;

    private Integer employeeCount = 0;

    private Integer clientCount = 0;

    private Integer rating;

    private Long totalMoney;

    private Double percentage;

    public Bank(Integer id, String name) {

        this.id = id;
        this.name = name;
        this.officeCount = 0;
        this.atmCount = 0;
        this.employeeCount = 0;
        this.clientCount = 0;
        this.rating = random.nextInt(101);
        this.totalMoney = random.nextLong(1000001);
        this.percentage = random.nextDouble() * 20;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOfficeCount() {
        return officeCount;
    }

    public void setOfficeCount(Integer officeCount) {
        this.officeCount = officeCount;
    }

    public Integer getAtmCount() {
        return atmCount;
    }

    public void setAtmCount(Integer atmCount) {
        this.atmCount = atmCount;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Integer getClientCount() {
        return clientCount;
    }

    public void setClientCount(Integer clientCount) {
        this.clientCount = clientCount;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", officeCount=" + officeCount +
                ", atmCount=" + atmCount +
                ", employeeCount=" + employeeCount +
                ", clientCount=" + clientCount +
                ", rating=" + rating +
                ", totalMoney=" + totalMoney +
                ", percentage=" + percentage +
                '}';
    }
}
