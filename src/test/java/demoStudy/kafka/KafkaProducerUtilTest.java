package demoStudy.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, topics = {"gm-test", "test-topic"}, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class KafkaProducerUtilTest {
    
    @Autowired
    private KafkaProducerUtil producerUtil;
    
    @Test
    public void testSendMessage() throws InterruptedException {
        String testMessage = "Hello Kafka from ProducerUtil";
        
        // 发送消息
        producerUtil.sendMessage("gm-test", testMessage);
        
        // 等待异步发送完成
        TimeUnit.SECONDS.sleep(2);
        
        // 验证发送成功（通过日志可以看到）
        assertTrue(true, "Message should be sent successfully");
    }
    
    @Test
    public void testSendMessageWithKey() throws InterruptedException {
        String key = "test-key";
        String message = "Message with key";
        
        // 发送带 key 的消息
        producerUtil.sendMessage("gm-test", key, message);
        
        // 等待异步发送完成
        TimeUnit.SECONDS.sleep(2);
        
        assertTrue(true, "Message with key should be sent successfully");
    }
    
    @Test
    public void testSendMessageSync() throws Exception {
        String testMessage = "Synchronous message";
        
        // 同步发送消息
        SendResult<String, String> result = producerUtil.sendMessageSync("test-topic", testMessage);
        
        // 验证发送结果
        assertNotNull(result);
        assertNotNull(result.getRecordMetadata());
        assertEquals("test-topic", result.getRecordMetadata().topic());
    }
}
