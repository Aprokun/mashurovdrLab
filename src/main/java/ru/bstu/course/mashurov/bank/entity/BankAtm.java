package ru.bstu.course.mashurov.bank.entity;

public class BankAtm {

    private Integer id;

    private String name;

    private String address;

    private String status;

    private String place;

    private String serviceEmployee;

    private boolean withdraw;

    private boolean deposit;

    private Long totalMoney;

    private Integer serviceCost;

    public BankAtm(
            Integer id, String name, String address, String status, String place, String serviceEmployee,
            boolean withdraw, boolean deposit, Long totalMoney, Integer serviceCost
    ) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.place = place;
        this.serviceEmployee = serviceEmployee;
        this.withdraw = withdraw;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.serviceCost = serviceCost;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getServiceEmployee() {
        return serviceEmployee;
    }

    public void setServiceEmployee(String serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    public boolean isWithdraw() {
        return withdraw;
    }

    public void setWithdraw(boolean withdraw) {
        this.withdraw = withdraw;
    }

    public boolean isDeposit() {
        return deposit;
    }

    public void setDeposit(boolean deposit) {
        this.deposit = deposit;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Integer serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public String toString() {
        return "BankAtm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", place='" + place + '\'' +
                ", serviceEmployee='" + serviceEmployee + '\'' +
                ", withdraw=" + withdraw +
                ", deposit=" + deposit +
                ", totalMoney=" + totalMoney +
                ", serviceCost=" + serviceCost +
                '}';
    }
}
