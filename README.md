
# Athlete API

A REST API built with Java and Spring Boot to manage athlete information through CRUD (Create, Read, Update, Delete) operations.

The project demonstrates how backend applications handle HTTP requests, process JSON data, and manage resources through REST endpoints.

## Features

- Create new athlete records
- Retrieve all athletes or search by ID
- Update existing athlete information
- Delete athlete records
- Handle HTTP requests and responses
- Store athlete data in memory

Each athlete has an ID, name, and position.

## Technologies Used

- Java 21
- Spring Boot
- Maven
- Docker
- Postman

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/athletes` | Retrieve all athletes |
| GET | `/athletes/{id}` | Retrieve an athlete by ID |
| POST | `/athletes` | Create a new athlete |
| PUT | `/athletes/{id}` | Update an athlete |
| DELETE | `/athletes/{id}` | Delete an athlete |

## How to Run

**Requirements:** Java 21 and Docker (optional).

1. Clone the repository:

```bash
git clone https://github.com/dnzalparslan/athlete-api.git
cd athlete-api
```

2. Start the Spring Boot application:

**macOS/Linux:**
```bash
./mvnw spring-boot:run
```

**Windows:**
```bash
mvnw.cmd spring-boot:run
```

3. The API will be available at:

`http://localhost:8080/athletes`

4. Use Postman to test the endpoints.

For example, send a POST request to `/athletes` with:

```json
{
  "name": "Alex Smith",
  "position": "Guard"
}
```

Athlete records are stored in memory and reset when the application restarts.

## Docker

Build the application and Docker image:

```bash
./mvnw clean package
docker build -t athlete-api .
```

Run the container:

```bash
docker run -p 8080:8080 athlete-api
```

## What I Learned

This project helped me gain hands-on experience with REST API development, HTTP methods, and backend programming using Spring Boot. I also practiced API testing with Postman, dependency management with Maven, and containerization with Docker.
