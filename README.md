**medAppo — Medical Appointment Service**

A simple, pragmatic **Spring-based** backend for 
managing doctors, patients, schedules and appointments.

Designed and implemented as a focused demo of real-world Java server patterns: 
_clean layered structure, JPA entities, DTOs, mapping and basic pagination/filtering._

**Key technologies used:**

• Java (modern LTS, e.g. 17+)
• Spring Boot (Web + Data)
• Spring Security (for auth)
• Spring Data ~ JPA / Hibernate
• PostgreSQL
• MapStruct (DTO ↔ entity mapping)
• Lombok (boilerplate reduction)
• Swagger (API docs)


**What this project contains**

- Domain entities: _Doctor, Patient, Schedule, Appointment_ (see com.example.med_appointment.entity)
- Layered structure: _controller, dto, service_ (and service.impl), _repository, mapper_
- Dynamic repository filtering for appointments (date/time, doctor, patient, status)
- MapStruct mappers to convert between entities and DTOs
- Simple pagination support for list endpoints
