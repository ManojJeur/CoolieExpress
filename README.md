# Coolie Express Backend

Coolie Express is a production-ready clean-architecture Spring Boot platform mapping travelers at train stations to nearby coolies (porters).

## Authentication & Authorization
- Robust OTP-backed registration process (simulated emails sent to server console strings).
- High-security stateless JSON Web Token (JWT) session validation.
- Segregated `TRAVELER`, `COOLIE`, and `ADMIN` authorizations.

## Technical Stack
- Java 17
- Spring Boot 3.2.x (Web, Security, Data JPA, Validation)
- MySQL Database
- Swagger OpenAPI 2.5
- Docker & Docker Compose

## Quick Setup
### 1. Database Start
Initialize the MySQL backend seamlessly using Docker:
```bash
docker-compose up -d
```

### 2. Application Launch
Execute the Spring Boot standard run daemon:
```bash
./mvnw clean spring-boot:run
```
*(Or native `mvn clean spring-boot:run`)*

### 3. API Interactive Documentation
Navigate your web browser to the standard Swagger dashboard to interact continuously with endpoints:
`http://localhost:8080/swagger-ui.html`

> **Note**: For authenticated endpoints, utilize the `/api/auth/register`. Monitor the local console printouts for your `[MOCK EMAIL/SMS SENDER]` payload with the magic activation OTP. Then trigger `/api/auth/verify-otp`, and finally fetch your Bearer token natively at `/api/auth/login`. Inject the Bearer into the topmost "Authorize" padlock to securely unlock profiles, searches, and bookings.
