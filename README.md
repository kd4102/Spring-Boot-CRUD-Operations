# Spring Boot CRUD Operations

A Student Management REST API built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL.

## About the Project

This project demonstrates how to build REST APIs using Spring Boot.
It performs CRUD operations on student records and uses MySQL to store data.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API

## Features

- Create a student
- Retrieve a student by ID
- Retrieve all students
- Update student details
- Delete a student
- Soft delete a student

## Project Structure

```text
src/main/java/in/strikes/crudSpringBootDemo/
├── controller/
│   └── StudentController.java
├── entity/
│   └── Student.java
├── repository/
│   └── StudentRepository.java
├── service/
│   └── StudentService.java
└── CrudSpringBootDemoApplication.java

   ```
## Database Configuration

This project uses MySQL as its database.

### Setup

1. Install and start MySQL Server.
2. Create the database:

   ```sql
   CREATE DATABASE student_crud_db;
3. Configure your local `application.properties` file:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
   spring.datasource.username=root
   spring.datasource.password=YOUR_MYSQL_PASSWORD

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. Replace `YOUR_MYSQL_PASSWORD` with your local MySQL password.

**Security:** Never upload your actual database password to GitHub.

## Running the Project

1. Clone this repository:

   ```bash
   git clone https://github.com/kd4102/Spring-Boot-CRUD-Operations.git
   ```

2. Open the project in IntelliJ IDEA.
3. Start MySQL Server and configure the database connection.
4. Run `CrudSpringBootDemoApplication.java`.

The application runs on:

`http://localhost:8080`

## API Features

| Operation | Description |
|---|---|
| Create | Add a new student |
| Read | Retrieve one or all students |
| Update | Update student details |
| Delete | Delete a student record |
| Soft Delete | Mark a student as deleted |

Refer to `StudentController.java` for the actual API endpoints.

## Author

Kundan Raj