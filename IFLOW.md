# 项目概述

这是一个基于 Spring Boot 的 Java Web 应用程序，集成了 Apache Kafka 用于消息处理。该项目演示了如何使用 Spring Kafka 进行消息的生产和消费。

## 主要技术栈

*   **Spring Boot 2.7.18**: 用于快速构建和部署应用程序。
*   **Spring Web**: 提供 RESTful Web 服务和 MVC 功能。
*   **Spring Kafka**: 简化与 Apache Kafka 的集成，用于发布和订阅消息。
*   **Maven**: 项目构建和依赖管理工具。
*   **Java 8**: 应用程序的主要编程语言。

## 核心功能

1.  **Kafka 消息生产**: 通过 `KafkaProducerUtil` 工具类向 Kafka topic (`gm-test`) 发送消息。
2.  **Kafka 消息消费**: 通过 `KafkaConsumerService` 监听并处理来自 Kafka topic (`gm-test`) 的消息。
3.  **Web 界面**: 提供一个简单的 Web 界面 (`HelloController`) 来查看最近接收到的 Kafka 消息，并提供发送测试消息的功能。
4.  **Kafka 测试接口**: 提供 REST API (`KafkaTestController`) 用于发送测试消息到 Kafka。

## 项目结构

```
src/
├── main/
│   ├── java/
│   │   └── demoStudy/
│   │       ├── Application.java              # Spring Boot 启动类
│   │       ├── HelloController.java          # 主页控制器，显示 Kafka 消息
│   │       ├── config/
│   │       │   └── KafkaConfig.java          # Kafka 配置类（当前为空）
│   │       ├── controller/
│   │       │   └── KafkaTestController.java  # Kafka 测试 REST 控制器
│   │       └── kafka/
│   │           ├── KafkaConsumerService.java # Kafka 消费者服务
│   │           └── KafkaProducerUtil.java    # Kafka 生产者工具类
│   └── resources/
│       └── application.properties            # 应用配置文件
└── test/
    └── java/
        └── demoStudy/
            └── kafka/
                ├── KafkaConsumerServiceTest.java # Kafka 消费者测试
                └── KafkaProducerUtilTest.java    # Kafka 生产者测试

```

## 配置

应用的主要配置在 `src/main/resources/application.properties` 文件中：

*   `server.port=8080`: 应用运行端口。
*   `spring.kafka.bootstrap-servers=localhost:9092`: Kafka 服务器地址。
*   `spring.kafka.consumer.group-id=springai-consumer-group`: Kafka 消费者组 ID。
*   `spring.kafka.consumer.auto-offset-reset=earliest`: 消费者偏移量重置策略。
*   其他 Kafka 序列化/反序列化配置。

## 构建和运行

### 前提条件

*   Java 8 或更高版本
*   Maven 3.6 或更高版本
*   运行中的 Apache Kafka 实例（监听 `localhost:9092`）

### 构建

```bash
mvn clean package
```

### 运行

```bash
mvn spring-boot:run
```

或者

```bash
java -jar target/springAI-1.0-SNAPSHOT.jar
```

应用启动后将在 `http://localhost:8080` 提供服务。

## 开发约定

*   使用 Spring Boot 注解进行依赖注入和组件管理。
*   控制器使用 `@RestController` 注解。
*   服务类使用 `@Service` 注解。
*   工具类使用 `@Component` 注解。
*   Kafka 监听器使用 `@KafkaListener` 注解。
*   测试使用 JUnit 5 和 Spring Boot Test。