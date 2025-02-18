# 🔐 Spring Boot JWT Authentication

A simple Spring Boot application implementing **JWT-based authentication**. It provides user registration, login, and secured API access using JSON Web Tokens (JWT).

---

## 📌 Features

✅ **User Authentication** – Register, login, and secure endpoints using JWT.  
✅ **JWT Token Handling** – Generate and validate.  
✅ **RESTful API** – Secure API endpoints with authentication.  

---

## 🛠️ Tech Stack

- **Backend:** Spring Boot, Spring Security, Spring Data JPA . 
- **Authentication:** JWT (JSON Web Token).  
- **Database:** MySQL.
- **Tools:** Maven, Lombok.

---

## 🚀 Project Setup & Installation

### Clone the Repository
```sh
git clone https://github.com/sachinda913/spring-jwt-basic.git
```

### Configure the Database
Modify `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jwt_demo
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### Run the Application
```sh
mvn clean and install
mvn spring-boot:run
```

---

## 🔑 API Endpoints & Usage

### Authentication APIs

| HTTP Method | Endpoint           | Description |
|------------|-------------------|-------------|
| `POST` | `/register` | Register a new user |
| `POST` | `/login` | Authenticate and get a JWT token |
| `GET` | `/get` | Get sample data to check Authentication is working correctley|

### How to Test JWT Authentication?

1. **Register a new user:**
   ```json
   POST /register  
   {
     "username": "user1",
     "password": "password123"
   }
   ```

2. **Login to get a JWT Token:**
   ```json
   POST /login  
   {
     "username": "user1",
     "password": "password123"
   }
   ```
   ✅ **Response:**
   ```json
   {
     "accessToken": "eyJhbGciOiJIUzI1..."
   }
   ```
   
## 🔒 Security & JWT Configuration

- The JWT is generated using a **secret key**:
  ```
  secret key is a BASE64 encoded key.
  secret key expiration is 60 * 60 * 10 # 10 hour.
  ```
- **Spring Security Configuration (`SecurityConfig.java`)**
  - Defines authentication and authorization rules.  
  - Allows `/register and /login` without authentication but secures other endpoints.
  - only can test with **POSTMAN**
  - if you want to check using browser uncomment "**formLogin**" in the SecurityConfig file.
---

## 🔗 Contact & Support
For any issues, feel free to open an issue on GitHub or reach out via email at `sachinda.nirosh@gmail.com`.  

---


