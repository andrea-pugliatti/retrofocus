# Retrofocus - Backoffice Backend

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-6.4.0-red.svg)](https://spring.io/projects/spring-security)

[English](#english)

---

### Descrizione del Progetto
**Retrofocus** è un'applicazione end-to-end completa per la gestione di un catalogo fotografico vintage (macchine fotografiche, obiettivi, innesti e fotografi). Questo repository contiene il **Backend (Backoffice)**, sviluppato per fornire una gestione robusta dei dati e un set di API REST per il frontend.

Ho progettato l'intera architettura dell'applicazione, focalizzandomi sulla scalabilità e sulla sicurezza.

### Caratteristiche Principali
- **Architettura Full-Stack**: Integrazione fluida tra un backend in Spring Boot e un frontend in React.
- **Spring Security**: Implementazione di un sistema di autenticazione e autorizzazione sicuro per l'accesso al backoffice.
- **Persistenza Dati**: Gestione completa del database MySQL tramite Spring Data JPA, con implementazione di tutte le operazioni **CRUD** per le entità principali.
- **REST API**: Esposizione di endpoint RESTful per permettere al client React di consumare i dati in modo efficiente.
- **Relazioni Complesse**: Gestione di relazioni One-to-Many e Many-to-Many tra macchine fotografiche, obiettivi e montature.

### Struttura della Codebase
Il progetto segue un'architettura standard a strati (Layered Architecture):

- `controller/`: Gestisce le richieste HTTP, sia per le viste Thymeleaf del backoffice che per gli endpoint REST API.
- `model/`: Contiene le entità JPA (Camera, Lens, Photographer, User, ecc.) che mappano le tabelle del database.
- `repository/`: Interfacce Spring Data JPA per l'accesso ai dati e l'esecuzione di query personalizzate.
- `repository/specification/`: Classi per la definizione di query dinamiche e filtri complessi tramite la Criteria API di JPA.
- `service/`: Contiene la logica di business dell'applicazione, fungendo da strato intermedio tra controller e repository.
- `security/`: Configurazione di Spring Security, gestione dei dettagli utente e permessi di accesso.
- `resources/templates/`: Viste HTML del backoffice realizzate con Thymeleaf.
- `resources/static/`: Asset statici (CSS, immagini delle macchine fotografiche e dei fotografi).

### Tech Stack
- **Java 25**
- **Spring Boot 4**
- **Spring Security**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Docker / Podman**

---

## English

### Project Overview
**Retrofocus** is a complete end-to-end application designed to manage a vintage photography catalog (cameras, lenses, mounts, and photographers). This repository hosts the **Backend (Backoffice)**, developed to provide robust data management and a comprehensive set of REST APIs for the frontend.

I designed the entire application architecture, with a strong focus on scalability and security.

### Key Features
- **Full-Stack Architecture**: Seamless integration between a Spring Boot backend and a React frontend.
- **Spring Security**: Implementation of a secure authentication and authorization system for backoffice access.
- **Data Persistence**: Full management of the MySQL database via Spring Data JPA, implementing all **CRUD** operations for the core entities.
- **REST API**: Exposure of RESTful endpoints to allow the React client to consume data efficiently.
- **Complex Relationships**: Management of One-to-Many and Many-to-Many relationships between cameras, lenses, and mounts.

### Codebase Structure
The project follows a standard Layered Architecture:

- `controller/`: Handles HTTP requests, for both backoffice Thymeleaf views and REST API endpoints.
- `model/`: Contains JPA entities (Camera, Lens, Photographer, User, etc.) that map to database tables.
- `repository/`: Spring Data JPA interfaces for data access and custom queries.
- `repository/specification/`: Classes for defining dynamic queries and complex filters using the JPA Criteria API.
- `service/`: Contains the application's business logic, acting as a middle layer between controllers and repositories.
- `security/`: Spring Security configuration, user details management, and access control.
- `resources/templates/`: Backoffice HTML views powered by Thymeleaf.
- `resources/static/`: Static assets (CSS, camera and photographer images).

### Tech Stack
- **Java 25**
- **Spring Boot 4**
- **Spring Security**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Docker / Podman**

---

## Guida all'avvio / Getting Started

### Prerequisiti / Prerequisites
- Docker o Podman
- Java 25 (per esecuzione locale / for local execution)

### Docker Compose
Per avviare l'intero stack (Database + App):
To start the entire stack (Database + App):

```bash
docker-compose up --build
```

### Podman (Kube Play)
Il progetto include anche una configurazione per Kubernetes/Podman:
The project also includes a configuration for Kubernetes/Podman:

```bash
podman kube play deployment.yaml
```
