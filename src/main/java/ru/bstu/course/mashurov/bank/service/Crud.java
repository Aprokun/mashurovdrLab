package ru.bstu.course.mashurov.bank.service;

public interface Crud<T> {

    T findOne(Integer id);

    T create(T entity);

    void delete(T entity);

    void update(T entity);

}
