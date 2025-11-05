package demoStudy;

import demoStudy.kafka.KafkaConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    
    private final KafkaConsumerService kafkaConsumerService;
    
    public HelloController(KafkaConsumerService kafkaConsumerService) {
        this.kafkaConsumerService = kafkaConsumerService;
    }
    
    @GetMapping("/")
    public String hello() {
        List<String> messages = kafkaConsumerService.getRecentMessages();
        
        StringBuilder html = new StringBuilder();
        html.append("<html><body>");
        html.append("<h1>Hello World!!!!</h1>");
        html.append("<h2>Kafka Messages from topic 'gm-test':</h2>");
        
        if (messages.isEmpty()) {
            html.append("<p><i>No messages received yet.</i></p>");
        } else {
            html.append("<p>Total messages: ").append(messages.size()).append("</p>");
            html.append("<ul>");
            for (String message : messages) {
                html.append("<li>").append(escapeHtml(message)).append("</li>");
            }
            html.append("</ul>");
        }
        
        html.append("<hr>");
        html.append("<p>Send a message: <a href='/kafka/send?message=Test'>Send Test Message</a></p>");
        html.append("</body></html>");
        
        return html.toString();
    }
    
    private String escapeHtml(String text) {
        if (text == null) {
            return "";
        }
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#x27;");
    }
}
