package com.furkanisitan.sampleDatabases;

import com.furkanisitan.entities.Customer;
import com.furkanisitan.service.CustomerManager;
import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class SampleDatabase1 {

    public static void initializeDatabase() {

        CustomerManager customerManager = new CustomerManager();
        Faker faker = new Faker();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // TODO Adding Customers
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setFirstname(faker.name().firstName());
            customer.setLastname(faker.name().lastName());
            customer.setEmail(faker.internet().emailAddress());
            customer.setPhoneNumber(faker.numerify("###-###-####"));
            customer.setDob(dateFormat.format(faker.date().birthday()));

            customerManager.insert(customer);
        }
    }
}
