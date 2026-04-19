# 🚂 Coolie Express

<div align="center">

# 🚂 Coolie Express

### A Scalable, Location-Aware Porter Booking Platform

<p>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.x-brightgreen.svg" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/Java-17-blue.svg" alt="Java 17" />
  <img src="https://img.shields.io/badge/PostgreSQL-Cloud-blue.svg" alt="PostgreSQL" />
  <img src="https://img.shields.io/badge/JWT-Secured-orange.svg" alt="JWT" />
  <img src="https://img.shields.io/badge/Docker-Enabled-blue.svg" alt="Docker" />
  <img src="https://img.shields.io/badge/Deployed-Render-success.svg" alt="Render" />
</p>

<p>
  <strong>Connecting travelers with nearby verified porters in real time.</strong>
</p>

</div>

---

## 🌐 Live Demo

* 🚀 **Backend Live URL**
  [https://coolieexpress.onrender.com](https://coolieexpress.onrender.com)

* 📄 **Swagger API Documentation**
  [https://coolieexpress.onrender.com/swagger-ui/index.html](https://coolieexpress.onrender.com/swagger-ui/index.html)

---

## 📖 Problem Statement

Navigating crowded railway stations with heavy luggage is often physically exhausting and inefficient. Travelers struggle to quickly find reliable porters, while porters lack a consistent and transparent way to connect with customers.

**Coolie Express** solves this problem by enabling:

* Real-time, location-based matching
* Verified porter availability
* Transparent pricing
* Faster and more convenient service booking

---

## ✨ Key Features

### 🔐 Secure Authentication

* Email OTP verification using `JavaMailSender`
* Stateless authentication with JWT
* Secure login and protected endpoints

### 👥 Role-Based Access Control (RBAC)

Supported roles:

* `TRAVELER`
* `COOLIE`
* `ADMIN`

Each role has dedicated access permissions and APIs.

### 📍 Real-Time Matching System

* Travelers can request porter service
* System finds the nearest available coolie
* Matching is based on current location and availability

### 💰 Dynamic Pricing

* Coolies can set their own `pricePerBag`
* Travelers receive transparent cost estimates before booking

### ⚙️ Clean Backend Architecture

* Layered architecture:

  ```
  Controller → Service → Repository → DTO
  ```
* Structured and maintainable codebase
* Explicit implementation without Lombok

### 📚 API Documentation

* Swagger/OpenAPI integrated
* Easy endpoint testing and exploration

### 🛑 Global Exception Handling

* Centralized exception handling
* Consistent and meaningful API responses

### 🐳 Containerized Deployment

* Dockerized application
* Easy deployment and environment setup

---

## 🧠 System Design Highlights

* Designed a stateless JWT-based authentication system
* Implemented role-based authorization with Spring Security
* Built scalable REST APIs with validation and structured responses
* Used DTOs to separate internal entities from external API contracts
* Applied centralized exception handling for robust error management
* Integrated cloud-hosted PostgreSQL for production deployment
* Enabled containerized deployment using Docker and Render

---

## 🔄 Application Workflow

```text
1. User registers as TRAVELER or COOLIE
2. OTP is sent to the registered email
3. User verifies account using OTP
4. User logs in and receives a JWT token
5. Coolie updates location, availability, and pricePerBag
6. Traveler requests a porter service
7. System matches the traveler with the nearest available coolie
8. Booking is confirmed
```

---

## 🏗️ Tech Stack

| Category          | Technology                 |
| ----------------- | -------------------------- |
| Backend           | Java 17, Spring Boot 3.2.x |
| Security          | Spring Security, JWT       |
| Database          | PostgreSQL (Render Cloud)  |
| ORM               | Hibernate, JPA             |
| Email Service     | JavaMailSender             |
| API Documentation | Swagger / OpenAPI          |
| Containerization  | Docker                     |
| Deployment        | Render                     |

---

## 📂 Project Structure

```text
src/
├── controller/
├── service/
├── repository/
├── dto/
├── entity/
├── config/
├── security/
├── exception/
└── util/
```

---

## ⚙️ Local Setup

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/ManojJeur/CoolieExpress.git
cd CoolieExpress
```

### 2️⃣ Start the Database

For local development:

```bash
docker-compose up -d
```

> Uses MySQL locally while PostgreSQL is used in production.

### 3️⃣ Run the Application

```bash
mvn clean spring-boot:run
```

### 4️⃣ Open Swagger UI

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 🔐 Authentication Flow

### Register

```http
POST /api/auth/register
```

### Verify OTP

```http
POST /api/auth/verify-otp
```

### Login

```http
POST /api/auth/login
```

After successful login, include the JWT token in the request header:

```http
Authorization: Bearer <your-token>
```

---

## 📌 Sample API Flow

```text
Traveler Register → Verify OTP → Login
                         ↓
                 Receives JWT Token
                         ↓
Traveler Requests Coolie Service
                         ↓
Nearest Available Coolie Found
                         ↓
Booking Confirmed
```

---

## 🚧 Future Improvements

* 📊 Real-time tracking using WebSockets
* 📱 Android / iOS mobile application
* 💳 Online payment gateway integration
* 🔄 Refresh token and session management
* 📈 Admin analytics dashboard
* 🛰️ Live location updates with maps integration
* ⭐ Traveler reviews and ratings for coolies

---

## 👨‍💻 Author

**Manoj Jeur**

* GitHub: [https://github.com/ManojJeur](https://github.com/ManojJeur)
* Project Repository: [https://github.com/ManojJeur/CoolieExpress](https://github.com/ManojJeur/CoolieExpress)

---

<div align="center">
  <strong>Made with ❤️ using Java, Spring Boot, and Docker</strong>
</div>
