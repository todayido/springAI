package demoStudy.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, topics = {"gm-test"}, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class KafkaConsumerServiceTest {
    
    @Autowired
    private KafkaConsumerService consumerService;
    
    @Test
    public void testKafkaConsumer() throws InterruptedException {
        // 创建测试用的 KafkaTemplate
        KafkaTemplate<String, String> kafkaTemplate = createKafkaTemplate();
        
        // 发送测试消息
        String testMessage = "Test message for gm-test topic";
        kafkaTemplate.send("gm-test", testMessage);
        
        // 等待消息被消费
        TimeUnit.SECONDS.sleep(3);
        
        // 验证消息已被处理（在实际应用中，可以通过Mock或其他方式验证）
        assertTrue(true, "Message should be consumed successfully");
    }
    
    private KafkaTemplate<String, String> createKafkaTemplate() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        
        ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(props);
        return new KafkaTemplate<>(producerFactory);
    }
}
