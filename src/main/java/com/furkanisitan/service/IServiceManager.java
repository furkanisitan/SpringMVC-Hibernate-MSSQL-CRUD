package com.furkanisitan.service;

import com.furkanisitan.entities.IEntity;
import org.jinq.orm.stream.JinqStream;

import java.util.List;

interface IServiceManager<T extends IEntity> {
    T get(Integer id);

    T get(JinqStream.Where<T, Exception> where);

    boolean insert(T entity);

    boolean update(T entity);

    boolean delete(T entity);

    boolean delete(Integer id);

    List<T> getList();

    List<T> getList(JinqStream.Where<T, Exception> where);
}
