package ru.bstu.course.mashurov.bank.entity;

import java.util.Date;

import static ru.bstu.course.mashurov.bank.Utils.random;

public class User {

    private Integer id;

    private String fullName;

    private Date birthDate;

    private String workPlace;

    private Integer montlySalary;

    private Integer creditRating;

    public User(Integer id, String fullName, Date birthDate, String workPlace, Integer creditRating) {

        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.workPlace = workPlace;
        this.montlySalary = random.nextInt(10001);
        this.creditRating = creditRating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public Integer getMontlySalary() {
        return montlySalary;
    }

    public void setMontlySalary(Integer montlySalary) {
        this.montlySalary = montlySalary;
    }

    public Integer getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Integer creditRating) {
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", workPlace='" + workPlace + '\'' +
                ", montlySalary=" + montlySalary +
                ", creditRating=" + creditRating +
                '}';
    }
}
