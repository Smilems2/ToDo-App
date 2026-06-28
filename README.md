
---

# To-Do Application

A lightweight, full-stack Web Application designed for seamless daily task management. Built with a robust **Java Spring Boot** backend, dynamic **Thymeleaf** server-side rendering, and a persistent **MySQL** database.

---

## Features

* **View Tasks:** Dynamic rendering of all pending and completed items on a unified dashboard.
* **Create Task:** Quick task entry through a streamlined input form.
* **Toggle Status:** Instant state switching between pending and completed.
* **Delete Task:** Permanent task removal with automatic list refreshment.

---

## Tech Stack

* **Backend Framework:** Java 17, Spring Boot (Spring MVC, Spring Data JPA)
* **Frontend Engine:** Thymeleaf, HTML5, CSS3
* **Database Management:** MySQL Server
* **Development Environment:** IntelliJ IDEA & Maven

---

## Project Structure

The core routing of this application is handled by `TaskController` under the package `com.app.todo_app.controller`.

```text
To-Do-Application/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/app/todo_app/
    │   │       ├── TodoApplication.java
    │   │       ├── controller/
    │   │       │   └── TaskController.java
    │   │       ├── models/
    │   │       │   └── Task.java
    │   │       └── service/
    │   │           └── TaskService.java
    │   └── resources/
    │       ├── application.properties
    │       └── templates/
    │           └── tasks.html
    └── test/
        └── java/
            └── com/app/todo_app/
                └── All Unit/Integration Tests

```

---

## API Endpoints & Routes

The `TaskController` maps web traffic using the base path `/tasks`:

| Method | Endpoint | Description | Frontend UI Action |
| --- | --- | --- | --- |
| 🟢 **GET** | `/tasks` | Fetches all tasks from the database | Renders `tasks.html` dashboard |
| 🔵 **POST** | `/tasks` | Appends a new task entry via form parameter | Redirects back to `/tasks` |
| 🟡 **GET** | `/tasks/{id}/toggle` | Inverts completion status of a target ID | Redirects back to `/tasks` |
| 🔴 **GET** | `/tasks/{id}/delete` | Removes the target task from persistence | Redirects back to `/tasks` |

---

## ⚙️ Configuration & Setup

### 1️Prerequisites

Ensure your local machine has the following configured:

* **Java Development Kit (JDK):** Version 17 or higher
* **Database Server:** MySQL Server 8.x
* **IDE:** IntelliJ IDEA (Community or Ultimate)

### 2️Database Setup

Log into your MySQL terminal or workbench and initialize the schema:

```sql
CREATE DATABASE todo_db;

```

### 3️Application Properties

Update your database credentials inside `src/main/resources/application.properties`:

```properties
spring.application.name=todo_app

# Database Connection Settings
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

# JPA & Hibernate Mapping Lifecycle
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

```

---

## Frontend Integration (Thymeleaf)

The presentation layer directly compiles data properties injected into the backend standard `Model` container.

### Core Architecture Snippets:

* **Data Looping:** Renders rows dynamically using `th:each="task : ${tasks}"`.
* **State Updates:** Inverts task progress variables via a dedicated route link targeting `/tasks/${task.id}/toggle`.
* **Resource Cleanup:** Links button or icon interactions directly to the path variable route `/tasks/${task.id}/delete`.

---

## Execution Guide

1. Launch **IntelliJ IDEA** and choose *Open*, selecting the root `To-Do-Application/` directory.
2. Allow Maven to index and pull down dependencies outlined in your `pom.xml`.
3. Locate `TodoApplication.java` inside your project explorer root package.
4. Click the green **Run** icon on your gutter or press `Shift + F10`.
5. Open your web browser of choice and access the application at:
👉 **`http://localhost:8080/tasks`**
