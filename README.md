# RESTful web app with Spring Boot and Ember.js


### Introduction for Spring Boot backend

This is a device inventory project written in `Java`, and uses `Maven`, `JUnit`, and `Lombok`. 
You can import a maven project through your favourite IDE ( IntelliJ, Eclipse, Netbeans) or run through command line, installing `mvn` package (you can download and install as it is mentioned [here](https://maven.apache.org/install.html). Depending on your IDE you may need to install a Lombok plugin.

The web service uses the following technologies:

- JDK 1.8
- Spring JPA 
- MySQL 8.0.22
- Maven 
- JUnit
- Postman (REST client)




### Contents

The entities created are:

- Admin
- Company
- Employee
- Device

The application packages are:

- configuration
- controller
- exception
- model
- repository
- service
	- dto
	- mapper 	



### How to start the application

You should be able to start the application by executing the following command:

```
$ mvn clean spring-boot:run
```
which starts a webserver on port 8080 ([http://localhost:8080]()).

### Testing

Some testing using JUnit 5 was added in order to make sure that the project methods are running properly.

### Definitions/Things to improve

1. A sample authorization system was added using Basic auth. Make sure to use the following credentials when trying to make requests:
	- username : admin
	- password : admin
	
	The above credentials can be found inside `SecurityConfig` class in the `configuration` package. A proper authorization system will be implemented.

2. Make sure to change the database credentials in `application.properties` file in order to connect to your database. 

3. Lombok was used in order to save lines of code. More about lombok [here](https://projectlombok.org/).

