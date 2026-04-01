package com.pranay;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Gemini")
@CrossOrigin("*")
public class GeminiController {

    private ChatClient chatClient;

    public GeminiController(GoogleGenAiChatModel chatModel){
        this.chatClient = ChatClient.create(chatModel);
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response = chatClient.prompt(message).call().content();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
