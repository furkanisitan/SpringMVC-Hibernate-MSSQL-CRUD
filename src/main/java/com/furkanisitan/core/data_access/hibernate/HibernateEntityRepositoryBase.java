package com.furkanisitan.core.data_access.hibernate;

import com.furkanisitan.core.data_access.IEntityRepository;
import com.furkanisitan.core.entities.IEntity;
import org.jinq.orm.stream.JinqStream;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateEntityRepositoryBase<T extends IEntity> implements IEntityRepository<T> {

    private Class<T> tClass;

    public HibernateEntityRepositoryBase(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public List<T> getAll(JinqStream.Where<T, Exception> where) {
        EntityManager entityManager = HibernateHelper.getEntityManager();
        try {
            return HibernateHelper.JPA_STREAM_PROVIDER.streamAll(entityManager, tClass).where(where).toList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        EntityManager entityManager = HibernateHelper.getEntityManager();
        try {
            return HibernateHelper.JPA_STREAM_PROVIDER.streamAll(entityManager, tClass).toList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public T getById(int id) {
        EntityManager entityManager = HibernateHelper.getEntityManager();
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
        EntityManager entityManager = HibernateHelper.getEntityManager();
        try {
            return HibernateHelper.JPA_STREAM_PROVIDER.streamAll(entityManager, tClass).where(where)
                    .findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public boolean add(T entity) {
        EntityManager entityManager = HibernateHelper.getEntityManager();
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
        EntityManager entityManager = HibernateHelper.getEntityManager();
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
        EntityManager entityManager = HibernateHelper.getEntityManager();
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
}
