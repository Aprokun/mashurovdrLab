package ru.bstu.course.mashurov.bank.entity.values;

public enum EmployeePostValues {
    DIRECTOR("director"), OPERATOR("operator"), OFFICE_EMPLOYEE("office employee");

    private final String value;

    EmployeePostValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
