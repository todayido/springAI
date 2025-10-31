package demoStudy.controller;

import demoStudy.kafka.KafkaProducerUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaTestController {
    
    private final KafkaProducerUtil producerUtil;
    
    public KafkaTestController(KafkaProducerUtil producerUtil) {
        this.producerUtil = producerUtil;
    }
    
    /**
     * 发送消息到 gm-test topic
     * @param message 消息内容
     * @return 响应信息
     */
    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        producerUtil.sendMessage("gm-test", message);
        return "Message sent to gm-test topic: " + message;
    }
    
    /**
     * 发送带 key 的消息
     * @param key 消息键
     * @param message 消息内容
     * @return 响应信息
     */
    @PostMapping("/send-with-key")
    public String sendMessageWithKey(@RequestParam String key, @RequestParam String message) {
        producerUtil.sendMessage("gm-test", key, message);
        return "Message sent to gm-test topic with key: " + key + ", message: " + message;
    }
}
