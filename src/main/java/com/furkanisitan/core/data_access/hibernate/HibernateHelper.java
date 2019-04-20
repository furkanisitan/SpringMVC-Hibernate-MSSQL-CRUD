package com.furkanisitan.core.data_access.hibernate;

import org.jinq.jpa.JinqJPAStreamProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class HibernateHelper {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    static final JinqJPAStreamProvider JPA_STREAM_PROVIDER;

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistence");
        JPA_STREAM_PROVIDER = new JinqJPAStreamProvider(ENTITY_MANAGER_FACTORY);
    }

    static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
