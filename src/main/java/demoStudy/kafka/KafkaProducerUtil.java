package demoStudy.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaProducerUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerUtil.class);
    
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    public KafkaProducerUtil(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    /**
     * 发送消息到指定 topic
     * @param topic 主题名称
     * @param message 消息内容
     */
    public void sendMessage(String topic, String message) {
        sendMessage(topic, null, message);
    }
    
    /**
     * 发送消息到指定 topic，带 key
     * @param topic 主题名称
     * @param key 消息键
     * @param message 消息内容
     */
    public void sendMessage(String topic, String key, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, message);
        
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("Message sent successfully to topic: {}, partition: {}, offset: {}",
                        topic,
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
            }
            
            @Override
            public void onFailure(Throwable ex) {
                logger.error("Failed to send message to topic: {}", topic, ex);
            }
        });
    }
    
    /**
     * 同步发送消息
     * @param topic 主题名称
     * @param message 消息内容
     * @return SendResult
     * @throws Exception
     */
    public SendResult<String, String> sendMessageSync(String topic, String message) throws Exception {
        return kafkaTemplate.send(topic, message).get();
    }
}
