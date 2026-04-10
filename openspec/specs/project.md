# Project Specification

## 1. Overview
Blue Apron Project is a large-scale Java 17 multi-module monorepo managed by Gradle (using Kotlin DSL). It provides comprehensive backend services, integrations, APIs for mobile/web frontends, data migrations, and internal tools. The project relies extensively on a proprietary internal core framework (`com.wonder:core-ng`).

## 2. Frameworks & Technologies
- **Language**: Java 17 (Features like `record` and `var` are widely used).
- **Core Framework**: `core.framework` (`com.wonder:core-ng` family), which includes:
  - `core-ng`: The base framework.
  - `core-ng-mongo`: MongoDB integration.
  - `core-ext-db`: Relational database extension.
  - `core-ext-open-api`: OpenAPI/Swagger documentation generation.
  - `core-ng-test`: Test framework integration.
- **Build System**: Gradle with Kotlin DSL (`build.gradle.kts`, `settings.gradle.kts`).
- **Frontend Technologies**: React/TypeScript exist in specific sub-directories (e.g., `ba-merch-site-frontend`) for internal site interfaces.

## 3. Core Dependencies & Versions
The project utilizes a BOM (Bill of Materials) pattern for version management via `com.wonder:wonder-dependencies:3.0.+`. Key explicitly defined dependencies include:

**Database & Messaging:**
- **MySQL**: `com.mysql:mysql-connector-j` (Version managed by `wonder-dependencies`)
- **MongoDB**: Driven by `com.wonder:core-ng-mongo`
- **PostgreSQL**: `org.postgresql:postgresql:42.7.7`
- **HSQLDB**: `org.hsqldb:hsqldb` (For testing)
- **Kafka**: `org.apache.kafka:kafka-clients:4.1.0` (with `org.lz4` excluded)

**Azure / Cloud:**
- **Azure Identity**: `com.azure:azure-identity:1.18.2`
- **Azure Event Hubs**: `com.azure:azure-messaging-eventhubs:5.21.3`

**RPC & Serialization:**
- **gRPC**: `io.grpc:grpc-netty`, `grpc-protobuf`, `grpc-stub` (Version `1.79.0`)
- **Protobuf**: `com.google.protobuf:protobuf-java:4.33.5`
- **Jackson**: `com.fasterxml.jackson.core:jackson-core`, `jackson-datatype-jsr310` (Version managed by platform)

**Security & Utilities:**
- **JJWT**: `io.jsonwebtoken:jjwt-api:0.13.0` (with `jjwt-impl` and `jjwt-jackson`)
- **Google API Client**: `com.google.api-client:google-api-client:2.9.0`
- **SSHJ**: `com.hierynomus:sshj:0.40.0`
- **OpenCSV**: `com.opencsv:opencsv:5.12.0`

## 4. Project Structure
The repository is split into various categorized directories:

- **`backend/`**: Core microservices (e.g., `blueapron-product-service`). Usually accompanied by `-interface` (API contracts), `-db-migration`, and `-mongo-migration` modules.
- **`frontend/`**: Web and mobile API gateways and merchant site backends (e.g., `ba-mobile-api`, `ba-web-api`, `ba-merch-site`). 
- **`utility/`**: Shared libraries used across multiple services (e.g., `common`, `logging-lib`, `branch-lib`, `amplitude-lib`).
- **`migration/`**: Data migration tools.
- **`test-tool/`**: Utilities specific for integration or QA testing.

## 5. Code Style
- **Conventions**: Modern Java patterns with heavy usage of `var` for local variables to reduce verbosity.
- **Data Models**: Use of Java 14+ `record` classes for immutable DTOs and Context data structures (e.g. `RescoreContext`).
- **Dependency Injection**: Utilizes a `Module` based DI injection via `bind(...)` commonly defined inside `ServiceModule.java`. Constructor injection or `@Inject` annotations are standard.
- **Constants**: Static properties should be defined explicitly at the top of the file. Configurations are fetched securely via injected properties `requiredProperty("app.xxx")`.
- **Stream API**: Heavy reliance on Java 8+ Streams API (`.stream().filter().map().toList()`).

## 6. Commenting & Documentation
- **Class-Level**: Every class/interface/record must include a Javadoc block with an `@author` tag.
  ```java
  /**
   * Description of the class/interface.
   *
   * @author <author_name>
   */
  public class ExampleClass { ... }
  ```
- **Inline Comments**: Prefer minimal inline comments, focusing primarily on *why* complex decisions or specific conditional filters were made, rather than restating *what* the code does. 
- **Logs**: Code relies on `core.framework.log.ActionLogContext.info(key, value)` for capturing structured, easily-parsable logs (e.g., filtering outcomes, score adjustments) instead of standard stdout/stderr printing. To prevent flooding, logs involving loops are typically bounded by a `LOG_LIMIT` (e.g., `max 15` entries).

## 7. Directory Rules & Configurations
- **Configurations (`app.properties`)**: Environment-specific properties are maintained directly within specific conf directories:
  - `src/main/resources/app.properties` (Default/Local)
  - `conf/dev/resources/app.properties`
  - `conf/uat/resources/app.properties`
  - `conf/prod/resources/app.properties`
  When adding a new property, it *must* be added to all environments and kept **alphabetically sorted** to pass CI validations.
- **Naming Conventions**: 
  - Submodules follow a strict `{domain}-service` or `{domain}-api` naming convention. 
  - API contracts and POJOs intended for shared usage are strictly isolated in `{domain}-interface` modules to maintain clean boundaries and prevent circular dependencies.