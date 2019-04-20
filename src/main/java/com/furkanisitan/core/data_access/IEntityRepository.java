package com.furkanisitan.core.data_access;

import com.furkanisitan.core.entities.IEntity;
import org.jinq.orm.stream.JinqStream;

import java.util.List;

public interface IEntityRepository<T extends IEntity> {

    List<T> getAll(JinqStream.Where<T, Exception> where);

    List<T> getAll();

    T getById(int id);

    T get(JinqStream.Where<T, Exception> where);

    boolean add(T entity);

    boolean update(T entity);

    boolean delete(T entity);
}
