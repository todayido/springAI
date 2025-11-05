package demoStudy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import demoStudy.kafka.KafkaProducerUtil;
import demoStudy.model.GmTestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/gm-test")
public class GmTestMessageController {
    
    private static final Logger logger = LoggerFactory.getLogger(GmTestMessageController.class);
    
    @Autowired
    private KafkaProducerUtil kafkaProducerUtil;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    /**
     * 发送测试消息到Kafka
     */
    @PostMapping("/send")
    public String sendTestMessage(@RequestBody GmTestMessage message) {
        try {
            // 将对象转换为JSON字符串
            String jsonMessage = objectMapper.writeValueAsString(message);
            
            // 发送到Kafka
            kafkaProducerUtil.sendMessage("gm-test", message.getFileCode(), jsonMessage);
            
            logger.info("Successfully sent GmTestMessage to Kafka: {}", message.getFileCode());
            return "Message sent successfully";
            
        } catch (Exception e) {
            logger.error("Failed to send message to Kafka", e);
            return "Failed to send message: " + e.getMessage();
        }
    }
    
    /**
     * 创建并发送一个示例消息
     */
    @PostMapping("/send-sample")
    public String sendSampleMessage() {
        try {
            // 创建示例消息
            GmTestMessage sampleMessage = createSampleMessage();
            
            // 将对象转换为JSON字符串
            String jsonMessage = objectMapper.writeValueAsString(sampleMessage);
            
            // 发送到Kafka
            kafkaProducerUtil.sendMessage("gm-test", sampleMessage.getFileCode(), jsonMessage);
            
            logger.info("Successfully sent sample GmTestMessage to Kafka");
            return "Sample message sent successfully";
            
        } catch (Exception e) {
            logger.error("Failed to send sample message to Kafka", e);
            return "Failed to send sample message: " + e.getMessage();
        }
    }
    
    /**
     * 创建示例消息
     */
    private GmTestMessage createSampleMessage() {
        GmTestMessage message = new GmTestMessage();
        
        // 设置基本字段
        message.setFileCode("FILE_001");
        message.setName("测试文件");
        message.setText("这是一个测试文件的内容");
        message.setSummary("测试文件摘要");
        message.setUserId("user123");
        message.setUserName("测试用户");
        message.setCreateDate(new Date());
        message.setUpdateTime(new Date());
        
        // 设置文件相关字段
        message.setUuid("uuid-123-456-789");
        message.setFilesize("1024");
        message.setRealmd5("md5hash123456");
        message.setType((byte) 1);
        message.setLevel((byte) 2);
        
        // 设置网络相关字段
        message.setSrcip("192.168.1.100");
        message.setDstip("192.168.1.200");
        message.setSrcport(8080L);
        message.setDstport(9200L);
        
        // 设置组织相关字段
        message.setOrgId("org001");
        message.setOrgPath("/org/dept1");
        
        // 设置状态字段
        message.setReadFlag((byte) 1);
        message.setSendFlag((byte) 0);
        message.setDeleteFlag((byte) 0);
        message.setJudgeFlag((byte) 0);
        
        // 设置计数字段
        message.setPriority(1);
        message.setOkNum(10);
        message.setJuemiNum(0);
        message.setJimiNum(0);
        message.setMimiNum(0);
        
        return message;
    }
}