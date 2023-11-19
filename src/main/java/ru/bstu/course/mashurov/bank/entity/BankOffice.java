package ru.bstu.course.mashurov.bank.entity;

public class BankOffice {

    private Integer id;

    private String name;

    private String address;

    private String status;

    private boolean isPossiblePlaceAtm;

    private Integer atmCount;

    private boolean isPossibleApplyForLoan;

    private boolean withdraw;

    private boolean deposit;

    private Long totalMoney;

    private Integer rentPrice;

    public BankOffice(
            Integer id, String name, String address, String status, boolean isPossiblePlaceAtm, Integer atmCount,
            boolean isPossibleApplyForLoan, boolean withdraw, boolean deposit, Long totalMoney, Integer rentPrice
    ) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.isPossiblePlaceAtm = isPossiblePlaceAtm;
        this.atmCount = atmCount;
        this.isPossibleApplyForLoan = isPossibleApplyForLoan;
        this.withdraw = withdraw;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.rentPrice = rentPrice;
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

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPossiblePlaceAtm() {
        return isPossiblePlaceAtm;
    }

    public void setPossiblePlaceAtm(boolean possiblePlaceAtm) {
        isPossiblePlaceAtm = possiblePlaceAtm;
    }

    public Integer getAtmCount() {
        return atmCount;
    }

    public void setAtmCount(Integer atmCount) {
        this.atmCount = atmCount;
    }

    public boolean isPossibleApplyForLoan() {
        return isPossibleApplyForLoan;
    }

    public void setPossibleApplyForLoan(boolean possibleApplyForLoan) {
        isPossibleApplyForLoan = possibleApplyForLoan;
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

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", isPossiblePlaceAtm=" + isPossiblePlaceAtm +
                ", atmCount=" + atmCount +
                ", isPossibleApplyForLoan=" + isPossibleApplyForLoan +
                ", withdraw=" + withdraw +
                ", deposit=" + deposit +
                ", totalMoney=" + totalMoney +
                ", rentPrice=" + rentPrice +
                '}';
    }
}
