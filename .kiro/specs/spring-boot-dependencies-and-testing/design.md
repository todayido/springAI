# Design Document

## Overview

This design addresses the missing dependencies in the Spring Boot project and implements comprehensive unit testing for the HelloController. The solution involves analyzing the current Maven configuration, identifying missing dependencies, and creating robust unit tests with proper mocking.

## Architecture

### Current Project Structure
- Spring Boot 2.7.18 application
- Kafka integration for message consumption
- REST controller serving HTML responses
- Basic test infrastructure with JUnit 5

### Missing Dependencies Analysis
Based on the code analysis, the following dependencies are missing or need to be added:

1. **Logging Dependencies**: SLF4J implementation (Logback is included in spring-boot-starter but may need explicit configuration)
2. **Test Dependencies**: MockMvc support, Mockito for mocking
3. **Web Test Dependencies**: Spring Boot Test Web slice
4. **JSON Processing**: Jackson for potential JSON handling (though not currently used)

## Components and Interfaces

### 1. Maven Dependencies Enhancement

#### Required Dependencies
```xml
<!-- Testing dependencies -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

<!-- Web testing support -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-test-autoconfigure</artifactId>
    <scope>test</scope>
</dependency>

<!-- Mockito for mocking (included in spring-boot-starter-test but explicit for clarity) -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <scope>test</scope>
</dependency>

<!-- AssertJ for fluent assertions (included in spring-boot-starter-test) -->
<dependency>
    <groupId>org.assertj</groupId>
    <artifactId>assertj-core</artifactId>
    <scope>test</scope>
</dependency>
```

### 2. HelloController Test Design

#### Test Class Structure
- **HelloControllerTest**: Main test class using `@WebMvcTest`
- **Mock Dependencies**: KafkaConsumerService will be mocked
- **Test Scenarios**: 
  - Empty messages list
  - Multiple messages display
  - HTML escaping functionality
  - HTTP response validation

#### Test Methods
1. `testHelloEndpointWithNoMessages()`: Verify behavior when no Kafka messages
2. `testHelloEndpointWithMessages()`: Verify proper message display
3. `testHtmlEscaping()`: Verify HTML special character escaping
4. `testResponseContentType()`: Verify HTTP response headers

## Data Models

### Test Data Structures
```java
// Test message samples
List<String> testMessages = Arrays.asList(
    "Simple message",
    "Message with <script>alert('xss')</script>",
    "Message with & special characters"
);

// Expected HTML patterns for validation
String expectedNoMessagesPattern = "No messages received yet";
String expectedMessageCountPattern = "Total messages: \\d+";
```

## Error Handling

### Test Error Scenarios
1. **Service Exception Handling**: Test behavior when KafkaConsumerService throws exceptions
2. **Null Safety**: Verify null message handling
3. **Empty String Handling**: Test empty message processing

### Dependency Resolution Issues
1. **Version Conflicts**: Ensure compatible versions across all dependencies
2. **Transitive Dependencies**: Verify no conflicting transitive dependencies
3. **Test Classpath**: Ensure test dependencies don't leak into runtime

## Testing Strategy

### Unit Testing Approach
1. **Isolation**: Use `@WebMvcTest` to test only the web layer
2. **Mocking**: Mock KafkaConsumerService to isolate controller logic
3. **Assertions**: Use AssertJ for fluent and readable assertions
4. **Coverage**: Aim for 100% line coverage of HelloController

### Test Configuration
```java
@WebMvcTest(HelloController.class)
class HelloControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private KafkaConsumerService kafkaConsumerService;
    
    // Test methods...
}
```

### Integration Testing Considerations
- Existing KafkaConsumerServiceTest provides integration testing
- HelloController tests focus on unit-level testing
- Clear separation between unit and integration test responsibilities

## Implementation Plan

### Phase 1: Dependency Updates
1. Update pom.xml with missing dependencies
2. Verify no version conflicts
3. Validate build process

### Phase 2: Unit Test Implementation
1. Create HelloControllerTest class
2. Implement test methods for all scenarios
3. Verify test coverage and assertions

### Phase 3: Validation
1. Run all tests to ensure they pass
2. Verify application still starts correctly
3. Check for any dependency conflicts