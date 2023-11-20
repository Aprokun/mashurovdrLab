package ru.bstu.course.mashurov.bank.service;

import ru.bstu.course.mashurov.bank.entity.BankOffice;
import ru.bstu.course.mashurov.bank.entity.Employee;

public interface EmployeeService extends Crud<Employee> {

    boolean transferEmployee(Employee employee, BankOffice bankOffice);

    boolean isEmployeeSuitable(Employee employee);
}
