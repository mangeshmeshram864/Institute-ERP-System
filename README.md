# Institute ERP System

A role-based Institute ERP System developed using Spring Boot, Spring Security, JWT, Hibernate/JPA, and PostgreSQL. The system provides secure authentication and separate dashboards for Admin, Counselor, and Student roles to manage institute operations efficiently.

---

## Features

- Role-based authentication and authorization using JWT
- Admin Dashboard
- Counselor Dashboard
- Student Dashboard
- User Registration and Login
- Student Management
- Counselor Management
- Secure REST APIs
- DTO-based Request and Response Handling
- Pagination and Filtering
- Global Exception Handling
- Validation Handling
- Status-based Soft Delete Management
- Layered Architecture Implementation
- Database Integration using Hibernate/JPA

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Hibernate / JPA
- Maven

### Database
- PostgreSQL

### Tools
- Postman
- Git & GitHub

---

## Project Architecture

The project follows a layered architecture structure:

```text
Controller Layer
    ↓
Service Layer
    ↓
Repository Layer
    ↓
Database
```

Additional layers:
- Security Layer
- Exception Handling Layer
- Validation Layer
- DTO Layer

---

## Authentication & Authorization

- JWT-based Authentication
- Secure Login System
- Role-based Access Control
- Protected APIs using Spring Security
- Password Encryption

---

## Modules

### Admin Module
- Manage Students
- Manage Counselors
- View Dashboard Data
- Activate/Deactivate Users

### Counselor Module
- Manage Student Information
- Access Dashboard Features

### Student Module
- Access Personal Dashboard
- View Details and Information

---

## DTO Implementation

DTOs (Data Transfer Objects) are used for:
- Request and Response Handling
- Secure Data Transfer
- Avoiding Direct Entity Exposure
- Maintaining Clean API Structure

---

## Exception Handling

Implemented centralized Global Exception Handling for:
- Invalid Requests
- Unauthorized Access
- Resource Not Found
- Validation Errors
- Internal Server Errors

---

## Pagination

Pagination is implemented for optimized data retrieval and improved API performance when handling large datasets.

---

## Soft Delete / Status Management

Instead of permanently deleting records from the database, status-based management is implemented to maintain data integrity and historical records.

Example:
- ACTIVE
- INACTIVE

---

## Database Integration

- PostgreSQL Database
- Hibernate/JPA ORM Mapping
- Entity Relationships
- Repository Pattern

---

## API Testing

All APIs were tested using Postman.

---

## Setup Instructions

### Clone the Repository

```bash
git clone <your-github-repository-link>
```

### Navigate to Project Directory

```bash
cd institute-erp-system
```

### Configure PostgreSQL Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## PostgreSQL Dependency

Add the following dependency in `pom.xml`:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

## Run the Application

```bash
mvn spring-boot:run
```

---

## Future Needs to Enhancements

- Email Notifications
- Docker Deployment
- File Upload Support
- Report Generation
- Microservices Architecture

---

## Author

Mangesh Meshram
