# Frontend Gateways Specification

## 1. Architecture and Module Division
In this system, the Gateway layer is divided into two independent service modules, unified under the `frontend` directory:
- **`website`**: The frontend gateway for regular users.
- **`backoffice`**: The backend management system gateway for administrators.

**Important Principle: Separation of Service and Interface**
To ensure clear modules and decoupled dependencies, all microservices and Gateway layers must separate `service` (concrete implementation and business logic) and `interface` (API definitions, Request/Response DTOs, View models, etc.) into different modules. In this way, if other services need to make a call, they only need to depend on the `interface` module. This applies equally to gateways, meaning `website` should be split into `website-interface` and `website`, and `backoffice` into `backoffice-interface` and `backoffice`.

**Important Principle: API Definition using Web Service Interfaces**
Unless there is a specific need to handle file uploads which requires direct `Controller` usage, gateway APIs MUST be defined using Web Service interfaces (with annotations like `@Path`, `@POST`, `@GET`), exactly like internal microservices. Do not use custom `AJAXController` implementations with manual `Request`/`Response` bean parsing.

**Important Principle: Separate Folder for Requests and Responses in Interface Module**
In the interface module, request and response files MUST be placed in a separate package/folder based on their domain, instead of being directly under the `api` package. For instance, `LoginAJAXRequest` and `LoginAJAXResponse` should be placed in the `user` folder (e.g., `app.website.user.api.user`). However, the API interface class itself (e.g., `UserAJAXWebService`) MUST remain directly under the top-level `api` package (e.g., `app.website.user.api`). This keeps the `api` package clean and makes the code structure more organized, just like in internal microservices.

**Important Principle: Clean Repository**
The repository should be kept clean. All `.classpath`, `.project`, `.settings/`, `*.bin`, `*.class`, `*.lock`, `.gradle/`, `.idea/`, and `build/` files/directories should be ignored in `.gitignore` and must not be committed to the repository.

**Important Principle: Validation Annotations**
All Entities (SQL `@Table` / Mongo `@Collection`), API Requests, and API Responses MUST include appropriate validation annotations (such as `@NotNull`, `@NotBlank`, `@Size`, `@Min`, `@Max`). This is essential to ensure fail-fast data validation at the framework level before the data reaches the business logic.

**Important Principle: Database Migration Modules**
If a service uses a relational database (MySQL/SQL), it MUST have a corresponding `{service-name}-db-migration` module (e.g., `user-service-db-migration`). If a service uses MongoDB, it MUST have a `{service-name}-mongo-migration` module. The migration module ensures schema versioning and initial data population are tied to the service's lifecycle.

**Service Naming Convention for Backoffice:**
Service classes that implement business logic specifically used by Backoffice (BO) interfaces MUST be named with a `BO` prefix (e.g., `BOUserService`). This ensures a clear separation between regular business logic and admin/backend logic.

**Interface Naming Convention:**
The interface module MUST be named with a `-interface` suffix relative to the service module name. For example, the interface module for `user-service` MUST be named `user-service-interface` (do NOT use names like `user-interface`).

## 2. API and Naming Conventions
To clarify the caller and usage context of APIs, the system establishes the following conventions:
- **Backoffice Internal Service APIs**: Internal APIs provided by microservices for the backoffice gateway to call. The path must include `/bo/`, and the class name must use the `BO` prefix.
  - *Example*: `@Path("/bo/company")`, `BOCreateCompanyRequest`
- **Gateway APIs Provided to Frontend Pages**: APIs exposed by `website` and `backoffice` gateways to frontend pages. The path must include `/ajax/`, and class names and view models must use `AJAX` as a suffix.
  - *Example*: `@Path("/ajax/company/list")`, `ListCompanyAJAXRequest`, `CompanyAJAXView`

---

## 3. Gateway API Design (API List)

### 3.1 Website Gateway APIs (`frontend/website`)
Operations for regular users.

**User & Auth**
- `POST /ajax/user/register`
  - Request: `RegisterUserAJAXRequest`
  - Response: `RegisterUserAJAXResponse`
- `POST /ajax/user/login`
  - Request: `LoginAJAXRequest`
  - Response: `LoginAJAXResponse` (contains Token and user info)

**Resource**
- `GET /ajax/company/list`
  - Request: `ListCompanyAJAXRequest`
  - Response: `ListCompanyAJAXResponse` (contains `CompanyAJAXView` list)
- `GET /ajax/room/list`
  - Request: `ListRoomAJAXRequest` (filters by company)
  - Response: `ListRoomAJAXResponse` (contains `RoomAJAXView` list)

**Reservation**
- `GET /ajax/reservation/calendar`
  - Request: `GetCalendarAJAXRequest` (params: room ID, date; restricted to 7 days in the future)
  - Response: `GetCalendarAJAXResponse` (contains 30-minute interval occupancy status view)
- `POST /ajax/reservation/reserve`
  - Request: `ReserveRoomAJAXRequest`
  - Response: `ReserveRoomAJAXResponse`
- `POST /ajax/reservation/cancel`
  - Request: `CancelReservationAJAXRequest`
  - Response: `CancelReservationAJAXResponse`

---

### 3.2 Backoffice Gateway APIs (`frontend/backoffice`)
Operations for administrators in the backend.

**Admin Auth**
- `POST /ajax/admin/login`
  - Request: `AdminLoginAJAXRequest`
  - Response: `AdminLoginAJAXResponse`

**Company Management**
- `POST /ajax/company/create`
  - Request: `CreateCompanyAJAXRequest`
  - Response: `CreateCompanyAJAXResponse`
- `DELETE /ajax/company/{id}`
  - Request: `DeleteCompanyAJAXRequest`
  - Response: `DeleteCompanyAJAXResponse`
- `GET /ajax/company/list`
  - Request: `ListCompanyAJAXRequest`
  - Response: `ListCompanyAJAXResponse` (contains `CompanyAJAXView` list)

**Room Management**
- `POST /ajax/room/create`
  - Request: `CreateRoomAJAXRequest`
  - Response: `CreateRoomAJAXResponse`
- `DELETE /ajax/room/{id}`
  - Request: `DeleteRoomAJAXRequest`
  - Response: `DeleteRoomAJAXResponse`
- `GET /ajax/room/list`
  - Request: `ListRoomAJAXRequest`
  - Response: `ListRoomAJAXResponse` (contains `RoomAJAXView` list)

**Reservation Management**
- `GET /ajax/reservation/list`
  - Request: `SearchReservationAJAXRequest` (supports searching by company, room)
  - Response: `SearchReservationAJAXResponse` (contains `ReservationAJAXView` list)

**User Management**
- `PUT /ajax/user/status`
  - Request: `UpdateUserStatusAJAXRequest` (activate/deactivate)
  - Response: `UpdateUserStatusAJAXResponse`

---

## 4. Backend Microservices BO API Design Example (Backend Microservices)
*Example of underlying microservice APIs for the `backoffice` gateway to aggregate and call.*

**Resource Service**
- `POST /bo/company` -> `BOCreateCompanyRequest` / `BOCreateCompanyResponse`
- `DELETE /bo/company/{id}` -> `BODeleteCompanyResponse`
- `GET /bo/company/list` -> `BOListCompanyRequest` / `BOListCompanyResponse`

**Account Service**
- `PUT /bo/user/status` -> `BOUpdateUserStatusRequest` / `BOUpdateUserStatusResponse`

**Reservation Service**
- `GET /bo/reservation/list` -> `BOSearchReservationRequest` / `BOSearchReservationResponse`