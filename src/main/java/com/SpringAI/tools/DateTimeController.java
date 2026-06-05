package com.SpringAI.tools;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateTimeController {

    private final ChatClient chatClient;

    public DateTimeController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/tools")
    public String tools(){
        return chatClient.prompt()
                .user("What is tomorrows date?")
                .tools(new DateTime())
                .call()
                .content();
    }
}
