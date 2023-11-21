package ru.bstu.course.mashurov.bank.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Person {
    private static int currentId;
    protected int id;
    protected String name;
    protected LocalDate birthdDate;

    private void initId() {
        id = currentId++;
    }

    public Person() {

        initId();

        this.name = "No name";
        this.birthDate = null;
    }

    public Person(Person person) {

        this.id = person.id;
        this.name = person.name;
        this.birthdDate = person.birthdDate;
    }

    public Person(String name, LocalDate birthDate) {

        initId();

        this.name = name;
        this.birthdDate = birthDate;
    }

    public Person(int id, String name, LocalDate birthDate) {

        this.id = id;
        this.name = name;
        this.birthdDate = birthDate;
    }

    @Override
    public String toString() {

        return """
            Person:{
                id='%s',
                name='%s',
                birthDate='%s'
            }
            """.formatted(getId(), getName(), getBirthdDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

}
