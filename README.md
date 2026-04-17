<div align="center">
  <h1>🚂 Coolie Express</h1>
  <p><strong>A Modern, Location-Aware Porter Booking Platform</strong></p>

  <!-- Badges -->
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.x-brightgreen.svg" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Java-17-blue.svg" alt="Java">
  <img src="https://img.shields.io/badge/MySQL-8.0-blue.svg" alt="MySQL">
  <img src="https://img.shields.io/badge/JWT-Protected-orange.svg" alt="JWT">
  <img src="https://img.shields.io/badge/Swagger-OpenAPI-yellow.svg" alt="Swagger">
</div>
<br/>

## 📖 Problem Statement
Navigating busy railway stations with heavy luggage is a stressful and physically demanding experience for travelers. Furthermore, finding a reliable, verified porter (coolie) at the right time and negotiating fair prices is often chaotic. On the other hand, porters struggle to find consistent work and connect with travelers efficiently in real-time. 

**Coolie Express** bridges this gap by providing a seamless digital platform that instantly connects travelers with nearby, verified porters, ensuring a smooth, transparent, and hassle-free transit experience.

## ✨ Core Functionalities
- **Robust Authentication System**: Secure user onboarding via **Email OTP Verification** (using JavaMailSender) and **Stateless JWT** (JSON Web Token) session validation.
- **Role-Based Access Control (RBAC)**: Segregated interfaces and APIs for `TRAVELER`, `COOLIE`, and `ADMIN`.
- **Location-Aware Booking**: Real-time geographical matching between travelers seeking assistance and the nearest available coolies.
- **Dynamic Pricing & Profile Setup**: Coolies can define their profile details including the `pricePerBag` letting travelers know upfront costs.
- **Modern SaaS UI**: A premium, responsive interface featuring interactive elements, harmonious color palettes, and structured grid layouts.
- **Clean Architecture Backend**: Maintainable and modular Spring Boot application utilizing DTOs, Controllers, Services, and Repositories without Lombok for complete control over domain entities.
- **Full API Documentation**: Automated API specifications using OpenAPI (Swagger) for rapid frontend/backend testing and integration.

## 🔄 Project Workflow
1. **Onboarding & Registration**: User selects a role (`TRAVELER` or `COOLIE`) and registers. The system generates a 4-digit OTP and sends it securely to the user's registered Email via SMTP. 
2. **Account Verification & Login**: The user verifies their account using the OTP from their email and subsequently logs in to receive a secure JWT Bearer token.
3. **Profile Configuration**: Coolies update their availability status, location data, and per-bag service charges.
4. **Initiating a Request**: A Traveler specifies their location and luggage requirements. The platform performs a dynamic query to identify nearby Coolies.
5. **Booking Confirmation**: Once a match is made, both parties are connected through the system, bridging the divide from the digital interface to physical assistance.

## 🛠️ Technical Stack
* **Backend Framework**: Java 17, Spring Boot 3.2.x (Web, Security, Data JPA, Validation, Mail)
* **Database**: MySQL with Hibernate/JPA for ORM and declarative querying
* **Security**: Spring Security integrated with custom JWT Filters and JavaMailSender for stateless multi-factor-like auth
* **Documentation**: Springdoc OpenAPI (Swagger UI)
* **Containerization**: Docker & Docker Compose for rapid zero-configuration development environments

## 🚀 Quick Setup & Installation

### 1. Database Initialization
Instantly fire up your MySQL backend using Docker:
```bash
docker-compose up -d
```

### 2. Application Launch
Start the Spring Boot standard run daemon:
```bash
./mvnw clean spring-boot:run
```
*(Or native `mvn clean spring-boot:run`)*

### 3. API Interactive Documentation
Navigate your web browser to the standard Swagger dashboard to interact continuously with endpoints:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

> 💡 **Developer Note for Testing Authentication**: 
> 1. Use the `/api/auth/register` endpoint to create a user.
> 2. The platform will send an actual **OTP via Email** to the registered address!
> 3. Verify the OTP at `/api/auth/verify-otp`.
> 4. Authenticate at `/api/auth/login` to retrieve your JWT token.
> 5. Click the top "Authorize" padlock in Swagger and input your token (format: `Bearer <token>`) to unlock all secured endpoints.

---
*Built with passion, focusing on Clean Code, Best Practices, and solving real-world logistical challenges.*
