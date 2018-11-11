package com.furkanisitan.dao;

import com.furkanisitan.entities.IEntity;
import org.jinq.orm.stream.JinqStream;

import javax.persistence.EntityManager;
import java.util.List;

public class Dao<T extends IEntity> implements IDao<T> {

    private Class<T> tClass;

    public Dao(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public T get(Integer id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            return entityManager.find(tClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public T get(JinqStream.Where<T, Exception> where) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            return HibernateUtil.JPA_STREAM_PROVIDER.streamAll(entityManager, tClass).where(where).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public boolean insert(T entity) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean update(T entity) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean delete(T entity) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean delete(Integer id) {
        T entity = get(id);
        return delete(entity);
    }

    @Override
    public List<T> getList() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            return HibernateUtil.JPA_STREAM_PROVIDER.streamAll(entityManager, tClass).toList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<T> getList(JinqStream.Where<T, Exception> where) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try {
            return HibernateUtil.JPA_STREAM_PROVIDER.streamAll(entityManager, tClass).where(where).toList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
