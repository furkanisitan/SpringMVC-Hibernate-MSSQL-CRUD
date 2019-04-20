package com.furkanisitan.webUI.listeners;

import com.furkanisitan.data_access.sample_databases.SampleDatabase1;

import javax.servlet.ServletContextEvent;

public class ServletListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SampleDatabase1.initializeDatabase();
    }
}
