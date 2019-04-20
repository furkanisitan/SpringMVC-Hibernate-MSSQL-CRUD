package com.furkanisitan.data_access.sample_databases;

import com.furkanisitan.business.abstrct.ICustomerService;
import com.furkanisitan.business.concrete.managers.CustomerManager;
import com.furkanisitan.entities.Customer;
import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SampleDatabase1 {

    public static void initializeDatabase() {

        ICustomerService customerService = new CustomerManager();
        Faker faker = new Faker();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Adding Customers
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setSalary(faker.number().numberBetween(1000, 3000));
            customer.setFullname(faker.name().fullName());
            customer.setEmail(faker.internet().emailAddress());
            customer.setPhoneNumber(faker.numerify("###-###-####"));
            customer.setDateOfBirth(dateFormat.format(faker.date().birthday()));

            customerService.add(customer);
        }
    }
}
