# Java Unit Testing

Java Unit 5 testing with Spring Boot 2.3.1 and Mockito Frameworks,
JsonAssert, Hamcrest & JsonPatch.

#### Overview
* [Spring Boot](https://spring.io/projects/spring-boot) is the most popular framework to develop
RESTful Services and it has great Unit Testing capabilities
through Spring Boot Starter Test. 
* [JUnit](https://junit.org/junit5/) is the most popular Java Unit Testing framework.
* [Mockito](https://site.mockito.org/) is the most popular mocking framework. 

#### Application Structure
The application structure is the following: 

![Application Structure](documentation/app_structure.png "Application Structure")


#### Goals
* Write great Unit and Integration tests using Spring Boot Starter Test
* Write unit tests using Mocks and Spys created with Mockito
* Write independent unit tests for RESTful web services talking with multiple layers - web, business and data
* Write integration tests using an in memory database - H2
* Use all the frameworks that are part of Spring Boot Starter Test - JUnit, Spring Test, Spring Boot Test, AssertJ, Hamcrest, Mockito, JSONassert and JsonPath.
* Use the most important Unit Testing Annotations - @SpringBootTest, @WebMvcTest, @DataJpaTest and @MockBean.

#### JUnit 5 vs JUnit 4
Functionally speaking, JUnit 5 is as simple as JUnit 4.
There are just a few simple annotation changes: 

![JUnit5 changes](documentation/junit5-changes.png "JUnit5 changes")


#### Recommended docs
* [xunitpatterns](http://xunitpatterns.com)
