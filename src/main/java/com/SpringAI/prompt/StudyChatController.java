package com.SpringAI.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/study")
public class StudyChatController {

    private final ChatClient chatClient;

    public StudyChatController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public String studyChat(@RequestParam String question){
        var systemInstruction = """
                You are a study panning helper.
                If students ask you any questions related answer them.
                You can only discuss study related topics.
                
                If asked about anything else, respond "I can only help with study related discussions."
                """;

        return chatClient.prompt()
                .user(question)
                .system(systemInstruction)
                .call()
                .content();
    }
}
