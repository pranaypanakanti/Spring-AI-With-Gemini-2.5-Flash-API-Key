package com.SpringAI.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/openAi")
public class OpenAi {

    private final ChatClient chatClient;

    public OpenAi(@Qualifier("openAiChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat")
    public String chat(){
        return chatClient.prompt()
                .user("Tell me a placement preparation tip.")
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
