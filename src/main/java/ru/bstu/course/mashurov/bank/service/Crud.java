package ru.bstu.course.mashurov.bank.service;

public interface Crud<T> {

    T findOne(Integer id);

    void create(T entity);

    void delete(T entity);

    void update(T entity);

}
