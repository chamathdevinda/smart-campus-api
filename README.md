<<<<<<< HEAD
# Smart Campus API

## Developer

Chamath Weerasinghe

## Description

This project is a RESTful API developed using JAX-RS (Jersey) for managing rooms and sensors in a Smart Campus environment. It allows users to create, retrieve, and manage rooms and sensors, as well as maintain relationships between them.

---

## Technologies Used

* Java
* JAX-RS (Jersey)
* Grizzly HTTP Server
* Maven

---

## Base URL

http://localhost:8080/api/v1/

---

## Endpoints

### Rooms

* POST /rooms
* GET /rooms
* GET /rooms/{id}
* DELETE /rooms/{id}

### Sensors

* POST /sensors
* GET /sensors
* GET /sensors?type=TYPE

---

## Sample cURL Commands

```bash
curl -X GET http://localhost:8080/api/v1/rooms

curl -X POST http://localhost:8080/api/v1/rooms \
-H "Content-Type: application/json" \
-d '{"id":"LIB-301","name":"Library Room","capacity":50}'

curl -X GET http://localhost:8080/api/v1/rooms/LIB-301

curl -X POST http://localhost:8080/api/v1/sensors \
-H "Content-Type: application/json" \
-d '{"id":"TEMP-001","type":"Temperature","status":"ACTIVE","currentValue":25.5,"roomId":"LIB-301"}'

curl -X GET http://localhost:8080/api/v1/sensors
```

---

## Testing

All endpoints were tested using Postman. Screenshots are included in the Screenshots folder.

---

## Report Answers

### Part 1

**JAX-RS Lifecycle**
By default, JAX-RS resource classes are instantiated per request. This means a new object is created for each incoming HTTP request. This helps avoid concurrency issues when handling data structures like lists or maps.

**HATEOAS**
Hypermedia as the Engine of Application State (HATEOAS) allows clients to dynamically navigate APIs using links provided in responses. This reduces dependency on static documentation and improves flexibility.

---

### Part 2

**Returning IDs vs Full Objects**
Returning only IDs reduces bandwidth usage but requires additional client requests. Returning full objects increases payload size but improves usability.

**DELETE Idempotency**
DELETE is idempotent. Sending the same DELETE request multiple times results in the same outcome — the resource remains deleted.

---

### Part 3

**@Consumes Behavior**
If a client sends data in an unsupported format, JAX-RS returns HTTP 415 Unsupported Media Type.

**QueryParam vs PathParam**
Query parameters are better for filtering because they are optional and flexible, unlike path parameters which are fixed.

---

### Part 4

**Sub-resource Locator Benefits**
It improves code organization by separating nested logic into smaller classes, making the API more maintainable.

---

### Part 5

**HTTP 422 vs 404**
422 is more appropriate because the request is valid but contains invalid data.

**Security Risk of Stack Traces**
Exposing stack traces reveals internal system details, which attackers can exploit.

**Why Filters for Logging**
Filters handle cross-cutting concerns globally, reducing code duplication and improving maintainability.

---

## Setup Instructions

1. Clone the repository
2. Open project in VS Code
3. Run the Main.java file
4. Server will start at http://localhost:8080

---

## Screenshots

All screenshots are located in the `Screenshots` folder.
