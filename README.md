# 🔐 Spring Boot JWT Authentication

A simple Spring Boot application implementing **JWT-based authentication**. It provides user registration, login, and secured API access using JSON Web Tokens (JWT).

---

## 📌 Features

✅ **User Authentication** – Register, login, and secure endpoints using JWT.  
✅ **JWT Token Handling** – Generate and validate.  
✅ **Role-Based Authorization** – Users and Admins have different permissions.  
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
git clone https://github.com/your-username/spring-jwt-auth.git
cd spring-jwt-auth
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
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | Authenticate and get a JWT token |
| `POST` | `/api/auth/refresh-token` | Refresh JWT token |

### Protected APIs (Require JWT)

| HTTP Method | Endpoint | Description |
|------------|---------|-------------|
| `GET` | `/api/users/profile` | Get user details |
| `GET` | `/api/admin/dashboard` | Admin-only access |

### How to Test JWT Authentication?

1. **Register a new user:**
   ```json
   POST /api/auth/register  
   {
     "username": "user1",
     "password": "password123"
   }
   ```

2. **Login to get a JWT Token:**
   ```json
   POST /api/auth/login  
   {
     "username": "user1",
     "password": "password123"
   }
   ```
   ✅ **Response:**
   ```json
   {
     "accessToken": "eyJhbGciOiJIUzI1...",
     "refreshToken": "eyJhbGciOiJIUzI2..."
   }
   ```

3. **Access Protected Endpoint:**
   Add the JWT token in the `Authorization` header:
   ```http
   GET /api/users/profile  
   Authorization: Bearer <JWT_TOKEN>
   ```

---

## 🔒 Security & JWT Configuration

- The JWT is generated using a **secret key** (`application.properties`):
  ```properties
  jwt.secret=your_secret_key
  jwt.expiration=3600000 # 1 hour in milliseconds
  ```
- **Spring Security Configuration (`SecurityConfig.java`)**
  - Defines authentication and authorization rules.  
  - Allows `/api/auth/**` without authentication but secures other endpoints.  

---

## 🔗 Contact & Support
For any issues, feel free to open an issue on GitHub or reach out via email at `sachinda.nirosh@gmail.com`.  

---

