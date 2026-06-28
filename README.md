# To-Do Application

A lightweight, full-stack Web Application built using **Spring Boot**, **Thymeleaf**, and **MySQL**. This application allows users to manage their daily tasks efficiently with operations to view, create, delete, and toggle the completion status of tasks.

## 🚀 Features

* **View Tasks:** Display all current tasks dynamically.
* **Create Task:** Add new tasks via a simple input form.
* **Toggle Task Status:** Mark tasks as completed or pending instantly.
* **Delete Task:** Remove tasks permanently from the list.

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot (Spring MVC, Spring Data JPA)
* **Frontend:** Thymeleaf, HTML5, CSS3
* **Database:** MySQL
* **IDE:** IntelliJ IDEA

## 📁 Project Structure

The core routing of this application is handled by `TaskController` under the package `com.app.todo_app.controller`.

text
src/main/java/
└── com/app/todo_app/
    ├── controller/
    │   └── TaskController.java  <-- Handles the web requests
    ├── models/
    │   └── Task.java            <-- Task Entity
    └── service/
        └── TaskService.java     <-- Business Logic

## 🔗 API Endpoints & Routes

The `TaskController` exposes the following endpoints under the `/tasks` base path:

| Method | Endpoint | Description | Frontend Action |
| --- | --- | --- | --- |
| **GET** | `/tasks` | Fetches all tasks and renders the `tasks.html` view. | Renders the task dashboard. |
| **POST** | `/tasks` | Creates a new task using the `title` request parameter. | Redirects back to `/tasks`. |
| **GET** | `/tasks/{id}/toggle` | Toggles the completion status (completed/pending) of a specific task. | Redirects back to `/tasks`. |
| **GET** | `/tasks/{id}/delete` | Deletes a specific task by its unique ID. | Redirects back to `/tasks`. |

## ⚙️ Configuration & Setup

### 1. Prerequisites

Ensure you have the following installed:

* Java 17 or higher
* MySQL Server
* IntelliJ IDEA

### 2. Database Setup

Create a MySQL database named `todo_db` (or your preferred name):

CREATE DATABASE todo_db;

### 3. Application Properties

Configure your connection inside `src/main/resources/application.properties`:

```properties
spring.application.name=todo_app

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

# JPA / Hibernate Properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

## 🖥️ Frontend Integration (Thymeleaf)

The controller routes traffic directly to the template located at `src/main/resources/templates/tasks.html`.

### Key Thymeleaf Snippets used:

* **Displaying Tasks:** Uses `th:each="task : ${tasks}"` to loop through the Java List passed by the `Model` container.
* **Toggling Status:** Uses an anchor tag or button targeting `/tasks/${task.id}/toggle`.
* **Deleting Tasks:** Uses an anchor tag targeting `/tasks/${task.id}/delete`.

## 🏃 How to Run the Application in IntelliJ IDEA

1. Clone or open this project directory in **IntelliJ IDEA**.
2. Let Maven reload and download all necessary dependencies specified in the `pom.xml`.
3. Open `TodoApplication.java` (the main class annotated with `@SpringBootApplication`).
4. Click the green **Run** button or press `Shift + F10`.
5. Open your web browser and navigate to: `http://localhost:8080/tasks`
