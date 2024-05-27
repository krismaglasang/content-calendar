# Content Calendar Project

## Overview

This project is a Spring Boot application for managing content. It uses PostgreSQL as the database and Docker for containerization.

## Getting Started

At the root of the project, create a `.env` file that contains the following:
```
PG_PORT=5437
PG_USERNAME=postgres
PG_PASSWORD=postgres
PG_DB=content_calendar_db
```

To run, open your terminal and type the following command:

```sh
docker-compose up --build
```

## Endpoints
### Get all contents
URL: localhost:8080/api/content

### Get content by ID
URL: localhost:8080/api/content/{id}

### Create a content
URL: localhost:8080/api/content

Payload:
```json
{
    "title": "another for deletion right here",
    "description": "for deletion",
    "status": "COMPLETED",
    "contentType": "ARTICLE",
    "dateCreated": "2024-05-18T12:19:20.752728",
    "dateUpdated": null,
    "url": "https://thinkingintensors.co.nz/ml-in-production"
}
```

### Update content
URL: localhost:8080/api/content/{id}
Payload:
```json
{
    "title": "for deletion",
    "description": "for deletion testing",
    "status": "COMPLETED",
    "contentType": "ARTICLE",
    "dateCreated": "2024-05-18T12:19:20.752728",
    "dateUpdated": null,
    "url": "https://thinkingintensors.co.nz/ml-in-production"
}
```

### Delete content
URL: localhost:8080/api/content/{id}

### Get by title
URL: localhost:8080/api/content/filter?keyword={keyword}

## Other Endpoints
### For testing out profiles
URL: localhost:8080/home

### Observability and Monitoring
URL: localhost:8080/actuator
