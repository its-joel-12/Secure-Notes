<h1 align="center">📝Secure Notes</h1>

## ✨About The Project

Secure Notes is a full-featured web application designed to securely store, manage, and share personal
notes. Built with Java 21 and Spring Boot, it leverages robust security practices including JWT-based
authentication, OAuth2 login (Google/GitHub), two-factor authentication (2FA) via Google Authenticator,
and role-based access control (admin/user). The backend uses JPA for database interactions and supports both
MySQL and PostgreSQL. Additional features include password reset via email, audit logging for note actions,
and a RESTful API documented with OpenAPI/Swagger. The project is containerized with Docker for easy
deployment and includes scheduled tasks for application keep-alive.

## ⚙️Project Dependencies & Versions:
- Java____ 21
- Maven__ 3.9.8
- Spring__ 3.4.4
### Maven Dependencies:
- Spring Web
- DevTools
- Spring Security
- Lombok
- Data Jpa
- MySql
- Postgresql
- Swagger Doc (OpenApi)
- Hibernate Validation
- jjwt-api
- jjwt-impl
- jjwt-jackson
- Starter Mail
- Oauth2 Client
- Google Auth

## Installation

1. Clone the repo:
    ```bash
    git clone https://github.com/its-joel-12/Secure-Notes.git
    ```
2. Go to the project directory:
   ```bash
   cd ./Secure-Notes
   ```
3. Create .env file and allow the IDE access it during project run:
   ```bash
   cp .env.sample .env
   ```
   > Add the required env credentials/values
4. Build the Project:
    ```bash
    mvn clean package
    ```
5. Run the JAR File:
    ```bash
    java -jar target/SecureNotes-0.0.1-SNAPSHOT.jar
    ```
   > Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

## 📁 Project Structure
```text
   Secure-Notes/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── secure/
│   │   │           ├── SecureNotesApplication.java
│   │   │           ├── config/           # Security, JWT, OAuth2, Mail configs
│   │   │           ├── controller/       # REST controllers
│   │   │           ├── model/            # JPA entities
│   │   │           ├── repository/       # Spring Data JPA repositories
│   │   │           ├── service/          # Business logic
│   │   │           ├── security/         # Security filters, JWT utils, 2FA
│   │   │           └── util/             # Utility classes
│   │   └── resources/
│   │       ├── application.properties    # Main config
│   │       ├── static/                   # Static web assets (if any)
│   └── test/
│       └── java/
│           └── com/
│               └── secure/
│                   └── ...               # Unit and integration tests
├── pom.xml
├── Dockerfile
├── README.md
```