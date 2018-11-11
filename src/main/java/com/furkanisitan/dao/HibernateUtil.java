package com.furkanisitan.dao;


import org.jinq.jpa.JinqJPAStreamProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    private static EntityManager entityManager;
    public static final JinqJPAStreamProvider JPA_STREAM_PROVIDER;

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistence");
        JPA_STREAM_PROVIDER = new JinqJPAStreamProvider(ENTITY_MANAGER_FACTORY);
    }

    public static EntityManager createEntityManager() {
        return entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
