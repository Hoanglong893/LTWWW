package com.example.chatai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {

    @Value("${groq.api.key}")
    private String apiKey;

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> body) {
        String userMessage = body.get("message");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        String requestBody = String.format("""
            {
              "model": "llama-3.3-70b-versatile",
              "messages": [{"role": "user", "content": "%s"}]
            }
        """, userMessage.replace("\"", "\\\""));

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(
                "https://api.groq.com/openai/v1/chat/completions",
                request, Map.class
        );

        var choices = (java.util.List) response.getBody().get("choices");
        var message = (Map) ((Map) choices.get(0)).get("message");
        return Map.of("response", (String) message.get("content"));
    }
}