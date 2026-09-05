# Job Application Tracker

A Spring Boot REST API for managing and tracking job applications with CRUD operations, filtering, pagination, validation, and global exception handling.

## 🎯 Project Overview

The Job Application Tracker is a backend application built to manage job application records through a RESTful API.

The project was developed with a focus on learning and applying real-world backend development concepts such as layered architecture, DTOs, validation, database persistence, API design, exception handling, filtering, and pagination.

## 🛠️ Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Persistence:** Spring Data JPA
- **Database:** MySQL
- **Build Tool:** Maven
- **API Documentation:** Swagger UI / OpenAPI
- **API Style:** REST
- **Version Control:** Git & GitHub

## ✨ Features

- Create new job applications
- Retrieve all job applications
- Retrieve a job application by ID
- Update existing job applications
- Delete job applications
- Search and filter applications
- Filter by company
- Filter by application status
- Filter by location
- Combine company and status filters
- Pagination support
- Request validation using DTOs
- Global exception handling
- Meaningful validation error responses
- Proper HTTP status codes and RESTful responses
- Interactive API documentation with Swagger UI

## 🏗️ Application Structure

The application follows a layered backend architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Main Components

- **Controller Layer** — Handles HTTP requests and API endpoints.
- **Service Layer** — Contains application and business logic.
- **Repository Layer** — Handles database operations using Spring Data JPA.
- **DTOs** — Separate API request/response models from the database entity.
- **Exception Handling** — Provides consistent error responses across the API.
- **Validation** — Validates incoming request data before processing.

## 🔌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/applications` | Get all applications with optional filtering |
| GET | `/applications/{id}` | Get an application by ID |
| POST | `/applications` | Create a new application |
| PUT | `/applications/{id}` | Update an application by ID |
| DELETE | `/applications/{id}` | Delete an application by ID |
| GET | `/applications/page` | Get applications with pagination |

### Filtering

The application supports filtering job applications by:

- Company
- Status
- Location
- Company + Status + Location

Pagination can also be used when retrieving application records.

## 📖 API Documentation

The API is documented using **Swagger UI** and **OpenAPI**.

Swagger UI provides an interactive interface to explore and test the available REST API endpoints.

### Swagger UI

Run the application locally and open:

```text
http://localhost:8080/swagger-ui/index.html
```

### OpenAPI Specification

The OpenAPI specification is available locally at:

```text
http://localhost:8080/v3/api-docs
```

> **Note:** These URLs use localhost, so they are accessible only when the application is running on your local machine.

## 🗄️ Database

The application uses **MySQL** for persistent storage and **Spring Data JPA** for database interaction.

Application data is stored and managed through the JPA repository layer.

## ▶️ How to Run

### Prerequisites

Make sure you have the following installed:

- Java
- Maven
- MySQL

### 1. Clone the repository

```bash
git clone https://github.com/Nithushan5566/JobApplication-Tracker.git
```

### 2. Create the MySQL database

Create a database for the application in MySQL.

### 3. Configure the application

Update the database configuration in:

```text
src/main/resources/application.properties
```

Add your MySQL username, password, and database configuration.

### 4. Run the application

Using Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## 🧠 What I Learned

This project helped me move beyond basic CRUD development and understand how a real backend application can be structured.

Through this project, I worked with:

- REST API design
- Layered architecture
- DTOs and data validation
- Spring Data JPA
- MySQL database integration
- Filtering and pagination
- Global exception handling
- Consistent API responses
- Swagger / OpenAPI documentation
- Git and GitHub workflow

## 🚀 Future Improvements

This project is part of my ongoing learning journey.

Some areas I plan to explore next include:

- Deploying the application to the cloud
- Adding authentication and authorization
- Building a frontend for the API
- Improving the application's architecture and features
- Exploring additional backend and deployment technologies

## Screenshots

### Swagger UI

Interactive API documentation and testing interface.

![Swagger UI](screenshots/swagger-overview.png)

### Get Applications with Filtering

![GET Applications](screenshots/get-applications.png)

### Create Application

![POST Application](screenshots/post-application.png)

### Update Application

![PUT Application](screenshots/put-application.png)



