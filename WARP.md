# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Project Overview

Spring Boot 2.7.18 application demonstrating Kafka message producer/consumer patterns. The application provides both a web interface and REST APIs for interacting with Kafka topics.

**Key Topic**: `gm-test` - primary Kafka topic for message production and consumption

## Common Commands

### Build and Run
```bash
# Clean and build
mvn clean package

# Run application
mvn spring-boot:run

# Run built JAR
java -jar target/springAI-1.0-SNAPSHOT.jar
```

### Testing
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=KafkaProducerUtilTest

# Run specific test method
mvn test -Dtest=KafkaProducerUtilTest#testSendMessage
```

### Prerequisites
- Java 8+
- Maven 3.6+
- Running Kafka instance at `localhost:9092`

## Architecture

### Message Flow Pattern
The application implements a producer-consumer pattern with in-memory message storage:

1. **Producer Flow**: `KafkaTestController` → `KafkaProducerUtil` → Kafka Topic (`gm-test`)
2. **Consumer Flow**: Kafka Topic (`gm-test`) → `KafkaConsumerService` (stores in synchronized ArrayList) → `HelloController` (displays)

### Component Responsibilities

**KafkaProducerUtil** (`@Component`)
- Provides async and sync message sending to Kafka topics
- Handles send callbacks with logging
- All message sends include result logging (partition, offset)

**KafkaConsumerService** (`@Service`)
- Listens to `gm-test` topic with `@KafkaListener`
- Maintains last 100 messages in thread-safe synchronized list
- Exposes `getRecentMessages()` and `clearMessages()` methods

**Controllers**
- `HelloController`: Root endpoint (`/`) renders HTML with recent messages
- `KafkaTestController`: REST API at `/kafka/*` for sending messages

### Testing Strategy
Tests use `@EmbeddedKafka` with broker on port 9092:
- Both producer and consumer tests require embedded Kafka
- `@DirtiesContext` ensures clean context between tests
- Tests wait 2-3 seconds for async operations to complete

### Configuration
All Kafka settings in `application.properties`:
- Bootstrap servers: `localhost:9092`
- Consumer group: `springai-consumer-group`
- String serializers/deserializers for both producer and consumer

## Code Conventions

- Controllers use `@RestController` annotation
- Service classes use `@Service` annotation
- Utility classes use `@Component` annotation
- Kafka listeners use `@KafkaListener` annotation with topic and group ID
- Constructor injection for all dependencies (no `@Autowired` on fields)
