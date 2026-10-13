# Spring Boot CRUD Operations

A Student Management REST API project built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL to demonstrate CRUD operations.

## About the Project

This project demonstrates CRUD (Create, Read, Update, Delete) operations on student records using REST APIs built with Spring Boot.

The application allows users to create student records, retrieve student details, update existing records, permanently delete records, and perform soft deletion.

It uses Spring Data JPA and Hibernate for database operations and MySQL for data storage. Postman was used to test the REST APIs.

The project follows a layered architecture consisting of Controller, Service, Repository, and Entity layers.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Postman
- IntelliJ IDEA

## Features

- Create a new student
- Retrieve a student by ID
- Retrieve all students
- Update student details
- Permanently delete a student
- Soft delete a student
- Return appropriate HTTP status codes for successful operations and missing records
- Test REST APIs using Postman

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

### Database Setup

1. Install and start MySQL Server.
2. Create the database:

   ```sql
   CREATE DATABASE student_crud_db;
   ```

3. Create `src/main/resources/application.properties` locally and configure the database connection:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
   spring.datasource.username=root
   spring.datasource.password=YOUR_MYSQL_PASSWORD

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. Replace `YOUR_MYSQL_PASSWORD` with your local MySQL password.

**Security:** Never upload your actual database password or other sensitive credentials to GitHub.

The `application.properties` file is excluded from this repository using `.gitignore`. Create and configure it locally before running the application.

## Running the Project

### Prerequisites

- Java JDK
- MySQL Server
- IntelliJ IDEA
- Maven or the included Maven Wrapper

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/kd4102/Spring-Boot-CRUD-Operations.git
   ```

2. Open the project in IntelliJ IDEA.
3. Start MySQL Server.
4. Create the `student_crud_db` database.
5. Configure your local `application.properties` file with your MySQL credentials.
6. Run `CrudSpringBootDemoApplication.java`.

The application runs at:

```text
http://localhost:8080
```

## API Endpoints

**Base URL:**

```text
http://localhost:8080/api/students
```

All endpoints can be tested using Postman.

### 1. Create Student

- **Method:** POST
- **Endpoint:** `/create`
- **Full URL:** `http://localhost:8080/api/students/create`
- **Purpose:** Creates a new student record.
- **Success Status:** `201 Created`

**Example Request Body:**

```json
{
  "name": "Rahul",
  "email": "rahul@example.com"
}
```

Note: Adjust the JSON fields according to the properties defined in the `Student` entity.

### 2. Get Student by ID

- **Method:** GET
- **Endpoint:** `/get?id=1`
- **Full URL:** `http://localhost:8080/api/students/get?id=1`
- **Purpose:** Retrieves a student using their ID.
- **Success Status:** `200 OK`
- **If the student is not found:** `404 Not Found`

### 3. Get All Students

- **Method:** GET
- **Endpoint:** `/getAll`
- **Full URL:** `http://localhost:8080/api/students/getAll`
- **Purpose:** Retrieves all student records.
- **Success Status:** `200 OK`
- **If no students are found:** `404 Not Found`

### 4. Update Student

- **Method:** PUT
- **Endpoint:** `/update?id=1`
- **Full URL:** `http://localhost:8080/api/students/update?id=1`
- **Purpose:** Updates an existing student's details.
- **Success Status:** `200 OK`
- **If the student is not found:** `404 Not Found`

**Request Body:** Send the updated student fields as JSON.

### 5. Permanently Delete Student

- **Method:** DELETE
- **Endpoint:** `/delete?id=1`
- **Full URL:** `http://localhost:8080/api/students/delete?id=1`
- **Purpose:** Deletes a student record through the service layer.
- **Success Status:** `200 OK`
- **Success Response:** `record deleted`
- **If the student is not found:** `404 Not Found`

### 6. Soft Delete Student

- **Method:** PATCH
- **Endpoint:** `/delete-soft?id=1`
- **Full URL:** `http://localhost:8080/api/students/delete-soft?id=1`
- **Purpose:** Performs a soft delete through the service layer.
- **Success Status:** `200 OK`
- **Success Response:** `record deleted`
- **If the student is not found:** `404 Not Found`

Soft deletion is intended to mark a record as deleted without physically removing it. The exact behavior depends on the implementation in `StudentService`.

## API Testing with Postman

Postman was used to test the REST API endpoints.

### Testing Steps

1. Start the Spring Boot application.
2. Open Postman.
3. Select the appropriate HTTP method.
4. Enter the endpoint URL.
5. For POST and PUT requests, select **Body → raw → JSON** and provide the request body.
6. For requests that require a student ID, pass the ID as a query parameter.
7. Click **Send** to view the response status and body.

## Author

**Kundan Raj**

GitHub: [kd4102](https://github.com/kd4102)