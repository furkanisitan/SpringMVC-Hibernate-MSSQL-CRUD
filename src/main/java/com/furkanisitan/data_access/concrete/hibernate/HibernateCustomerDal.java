package com.furkanisitan.data_access.concrete.hibernate;

import com.furkanisitan.core.data_access.hibernate.HibernateEntityRepositoryBase;
import com.furkanisitan.data_access.abstrct.ICustomerDal;
import com.furkanisitan.entities.Customer;

public class HibernateCustomerDal extends HibernateEntityRepositoryBase<Customer> implements ICustomerDal {
    public HibernateCustomerDal(Class<Customer> customerClass) {
        super(customerClass);
    }
}
