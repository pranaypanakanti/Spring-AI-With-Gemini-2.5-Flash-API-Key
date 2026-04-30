package com.SpringAI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get-responce")
@CrossOrigin("*")
public class GenAIController {

    private ChatClient chatClient;

    public GenAIController(GoogleGenAiChatModel chatModel){
        this.chatClient = ChatClient.create(chatModel);
    }

    @Autowired
    private GenAIService genAIService;

    @GetMapping()
    public ResponseEntity<String> getAnswer(@RequestBody String message){
        String response = genAIService.getResponse(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
