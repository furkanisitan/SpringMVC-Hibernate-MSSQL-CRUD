# SpringMVCHibernateMSSQL

This project is a n-tier web application that demonstrates the CRUD operations using Spring MVC, Hibernate and MSSQL.


## Requirements
* [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [MSSQL](https://www.microsoft.com/tr-tr/sql-server/sql-server-2017-editions)
* [Hibernate 5.4](https://hibernate.org/orm/documentation/5.4/)
* [Spring Web MVC 5.1.6](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#spring-web)
* [mssql-jdbc](https://github.com/Microsoft/mssql-jdbc)
* [jinq](http://www.jinq.org/docs/)
* [javafaker](https://github.com/DiUS/java-faker)
* [Bootstrap 4](https://getbootstrap.com/docs/4.3/getting-started/introduction/)


## Getting Started

**1. Clone or download the project**

**2. Create MsSql database**

```
CREATE DATABASE SpringMvcHibernateTest;
```

- Through Hibernate, tables will be automatically generated according to entity classes.

- While the project is first opened, fake data is produced with javafaker and sample data is added to the database.

**3. Import the project as a maven project.**

**4. Change mssql username, password and servername as per your installation**

+ open `src/main/resources/META-INF/persistence.xml`

+ change `jdbc:sqlserver`, `javax.persistence.jdbc.user` and  `javax.persistence.jdbc.password` as per your mssql installation

**5. Build and run the app project**

## Demo

![spring-mvc](https://user-images.githubusercontent.com/18014357/57171098-de0ad380-6e19-11e9-9ed5-ad94c9fc1fd2.gif)
