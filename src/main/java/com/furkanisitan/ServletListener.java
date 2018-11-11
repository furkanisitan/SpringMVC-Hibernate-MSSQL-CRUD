package com.furkanisitan;

import com.furkanisitan.sampleDatabases.SampleDatabase1;

import javax.servlet.ServletContextEvent;

public class ServletListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SampleDatabase1.initializeDatabase();
    }
}
