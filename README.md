# Content Calendar Project

## Overview

This project is a Spring Boot application for managing content. It uses PostgreSQL as the database and Docker for containerization.

## Getting Started

At the root of the project, create a `.env` file that contains the following:
```
PG_PORT=5432
PG_USERNAME=<insert username>
PG_PASSWORD=<insert password>
PG_DB=<insert database name>
```

To run, open your terminal and type the following command:

```sh
docker compose up --build
```

## Endpoints
### Get all contents
URL: localhost:8080/api/content

### Get content by ID
URL: localhost:8080/api/content/{id}

### Create a content
URL: localhost:8080/api/content

Example payload:
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

Example payload:
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
