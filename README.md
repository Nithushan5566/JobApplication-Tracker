# Job Application Tracker

A Spring Boot REST API for managing and tracking job applications.

## Tech Stack 
- Java 
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST API
- Swagger UI / OpenAPI

## Features
- Create, retrieves, update, and delete job applications.
- Search and filter applications by company, status, and location.
- Pagination support for application listings.
- Input validation for application data.
- Global exception handling with meaningful error responses.
- RESTful API design.
- Interactive API documentation with Swagger UI.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/applications` | Get all applications with optional filtering |
| GET | `/applications/{id}` | Get an application by ID |
| POST | `/applications` | Create a new application |
| PUT | `/applications/{id}` | Update an application by ID |
| DELETE | `/applications/{id}` | Delete an application by ID |
| GET | `/applications/page` | Get applications with pagination |

## API Documentation

The API is documented using Swagger UI and OpenAPI.

Swagger UI provides an interactive interface to explore and test all available REST API endpoints.

### Swagger UI

Run the application locally and open:

`http://localhost:8080/swagger-ui/index.html`

### OpenAPI Specification

The OpenAPI specification is available locally at:

`http://localhost:8080/v3/api-docs`

>*Note:* These URLs use localhost, so they are accessible only when the application is running on your local machine. They will not work directly from GitHub.

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



