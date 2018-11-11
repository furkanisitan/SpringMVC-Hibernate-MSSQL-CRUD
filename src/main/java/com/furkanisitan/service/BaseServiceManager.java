package com.furkanisitan.service;

import com.furkanisitan.dao.Dao;
import com.furkanisitan.entities.IEntity;
import org.jinq.orm.stream.JinqStream;

import java.util.List;

class BaseServiceManager<T extends IEntity> implements IServiceManager<T>  {

    private Class tClass;
    private Dao<T> dao;

    public BaseServiceManager(Class tClass) {
        this.tClass = tClass;
        dao = new Dao(tClass);
    }

    @Override
    public T get(Integer id) {
        return dao.get(id);
    }

    @Override
    public T get(JinqStream.Where<T, Exception> where) {
        return dao.get(where);
    }

    @Override
    public boolean insert(T entity) {
        return dao.insert(entity);
    }

    @Override
    public boolean update(T entity) {
        return dao.update(entity);
    }

    @Override
    public boolean delete(T entity) {
        return dao.delete(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return dao.delete(id);
    }

    @Override
    public List<T> getList() {
        return dao.getList();
    }

    @Override
    public List<T> getList(JinqStream.Where<T, Exception> where) {
        return dao.getList(where);
    }
}
