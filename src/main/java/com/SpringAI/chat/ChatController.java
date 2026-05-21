package com.SpringAI.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {


    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message){
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    @GetMapping("/chat/stream")
    public Flux<String> stream(){
        return chatClient.prompt()
                .user("Tell me the top 3 mistakes students make in placement interviews.")
                .stream()
                .content();
    }

    @GetMapping("/chat/response")
    public ChatResponse response(){
        return chatClient.prompt()
                .user("Tell me the top 3 mistakes students make in placement interviews.")
                .call()
                .chatResponse();
    }

}
