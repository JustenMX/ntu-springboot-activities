Create a new Spring Boot project titled `simple-crm`.

Add a Customer POJO class with the following properties:

```java
private String id;
private String firstName;
private String lastName;
private String email;
private String contactNo;
private String jobTitle;
private int yearOfBirth;
```

Use the `@Component` annotation to tell Spring Boot that this class is a component that can be injected into other classes.

Inject it into the controller using the `@Autowired` annotation.

Create a new endpoint `/customer` that returns a Customer object with some preset values.
