package demoStudy.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import demoStudy.es.ElasticsearchUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    private static final String INDEX_NAME = "gm-test";

    // 存储最近接收的消息（最多保存100条）
    private final List<String> recentMessages = Collections.synchronizedList(new ArrayList<>());
    private static final int MAX_MESSAGES = 100;

    @Autowired
    private ElasticsearchUtil elasticsearchUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "gm-test", groupId = "gm-test")
    public void listen(@Payload String message,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                       @Header(KafkaHeaders.OFFSET) long offset) {
        logger.info("Received message from topic gm-test: {}", message);
        logger.info("Partition: {}, Offset: {}", partition, offset);

        // 处理消息逻辑
        processMessage(message);
    }

    public void processMessage(String message) {
        // 在这里添加你的业务逻辑
        logger.info("Processing message: {}", message);

        try {
            // 解析JSON消息
            Map<String, Object> document = objectMapper.readValue(message, Map.class);

            // 生成唯一ID
            String documentId = UUID.randomUUID().toString();

            // 存储到Elasticsearch
            elasticsearchUtil.indexDocument(INDEX_NAME, documentId, document);
            logger.info("Document indexed to {} with ID: {}", INDEX_NAME, documentId);
        } catch (IOException e) {
            logger.error("Failed to process message: {}", message, e);
        }

        // 存储消息到内存列表
        synchronized (recentMessages) {
            recentMessages.add(message);
            // 如果超过最大数量，移除最旧的消息
            if (recentMessages.size() > MAX_MESSAGES) {
                recentMessages.remove(0);
            }
        }
    }

    /**
     * 获取所有最近的消息
     * @return 消息列表
     */
    public List<String> getRecentMessages() {
        synchronized (recentMessages) {
            return new ArrayList<>(recentMessages);
        }
    }

    /**
     * 清空所有消息
     */
    public void clearMessages() {
        synchronized (recentMessages) {
            recentMessages.clear();
        }
    }
}
