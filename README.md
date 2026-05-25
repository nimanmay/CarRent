Car Rental Service Backend
Scalable backend car rental platform built using Spring Boot, JDBC, PostgreSQL, Redis, and Bucket4j API rate limiting.

Features
Car booking system
REST APIs
Concurrent booking handling
API rate limiting
PostgreSQL integration
Redis caching
Layered architecture
Exception handling
Scalable backend design
Tech Stack
Java 17
Spring Boot
JDBC
PostgreSQL
Redis
Bucket4j
Maven
API Endpoints
Get Available Cars
GET /api/cars/available

Book Car
POST /api/bookings

Rate Limiting
Implemented Bucket4j + Redis-based API throttling to:

Prevent API abuse
Handle excessive traffic
Improve backend stability
Protect services under high concurrent load
Future Improvements
JWT Authentication
Kafka Integration
Docker Deployment
Kubernetes
AWS Deployment
