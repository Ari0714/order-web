# Order Web

A Spring Boot-based order analytics demo application that combines MySQL data, Kafka message consumption, Redis aggregation, and a simple ECharts dashboard for visualizing product sales information.

## Overview

This project exposes lightweight backend endpoints and serves a browser dashboard for order-related statistics. It is designed to demonstrate how a Java web application can:

- Query user information from MySQL
- Consume Kafka messages and persist incoming payloads
- Read aggregated order data from Redis
- Render chart data in the browser with ECharts

## Features

- Spring Boot REST API
- MyBatis-based database access
- Kafka consumer integration
- Redis hash reads for business metrics
- Dashboard page using ECharts and jQuery
- Simple product sales summary chart

## Tech Stack

- Java 8
- Spring Boot 3.5.7
- Spring Web
- MyBatis / MyBatis-Plus
- MySQL
- Redis
- Apache Kafka
- FreeMarker
- Swagger 2
- ECharts

## Project Structure

```text
order-web/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/web/
│   │   │       ├── Application.java
│   │   │       ├── bean/
│   │   │       ├── controller/
│   │   │       ├── Dao/
│   │   │       └── service/
│   │   ├── resources/
│   │   │   └── application.properties
│   │   └── webapp/
│   │       ├── index.html
│   │       └── js/
│   └── test/
│       └── java/
├── pom.xml
├── .gitignore
└── README.md
```

## Prerequisites

Before running the project, make sure these services are available:

- Java 8 or later
- Maven
- MySQL database
- Redis server
- Kafka broker

## Configuration

Edit `src/main/resources/application.properties` to match your local environment.

Example settings:

```properties
server.port=8084

spring.datasource.url=jdbc:mysql://hdp:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

spring.kafka.bootstrap-servers=hdp:9092
spring.kafka.consumer.group-id=test-group-ari
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.enable-auto-commit=false
```

Note: Replace `hdp` and credentials with the actual hostnames and credentials for your MySQL, Redis, and Kafka services.

## Running the Project

### Build

```bash
mvn clean package
```

### Start the application

```bash
mvn spring-boot:run
```

Or run the packaged jar:

```bash
java -jar target/order-web-0.0.1-SNAPSHOT.jar
```

The application listens on port `8084` by default.

## API Endpoints

### Get user by username

```http
GET /getUser?username=alice
```

Returns a serialized `AppBean` object from MySQL.

### Get product sales summary

```http
GET /getPart31
```

Reads data from the Redis hash:

```text
business::order::total
```

and returns a JSON payload shaped like:

```json
{
  "key": ["itemA", "itemB"],
  "val": [1200, 980]
}
```

This payload is used by the frontend ECharts chart.

## Frontend Dashboard

The dashboard is served from:

```text
src/main/webapp/index.html
```

It loads ECharts and requests `/getPart31` to render a bar chart titled "商品销售额汇总" (product sales summary).

## Database and Message Notes

The project includes examples for:

- reading user records from a table named `users_info`
- inserting data into `admin`
- consuming Kafka topic `test_t`

These names may need to be adjusted to match your actual schema and environment.

## Common Development Notes

- The app uses a simple raw HTML/JavaScript dashboard rather than a modern frontend framework.
- Redis and Kafka are expected to be reachable from the host names configured in `application.properties`.
- Some code appears to be demo or experimental in nature and may need cleanup depending on your production requirements.

## License

This project currently does not declare a specific license.

## Summary

`order-web` is a lightweight backend and dashboard sample for tracking order data, exposing REST APIs, and visualizing business metrics with ECharts. It is suitable as a starting point for a data-driven order management or analytics demo.
