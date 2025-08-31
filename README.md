**Blog Project**

A production-oriented, **Spring-based backend** for a simple blog platform supporting posts, users, comments and likes.
Implemented as a typical Spring Boot service with a layered design (controller → service → repository), JPA entities, DTOs, mapping and et cetera.

Designed and implemented as a focused demo of real-world Java server patterns: 
clean layered structure, JPA entities, DTOs, mapping and basic pagination/filtering.


**Key technologies used:** 

• Java 21 

• Spring Boot (Web + Data) 

• Spring Security (for auth) 

• Spring Data ~ JPA / Hibernate 

• PostgreSQL 

• MapStruct (DTO ↔ entity mapping) 

• Lombok (boilerplate reduction) 

• Swagger (API docs)


**Overall:**

Domain entities: User, Post, Like, Comment

Layered structure: controller, dto, service (and service.impl), repository, mapper 

Dynamic repository filtering for appointments (date/time, doctor, patient, status) 

MapStruct mappers to convert between entities and DTOs Simple pagination support for list endpoints


