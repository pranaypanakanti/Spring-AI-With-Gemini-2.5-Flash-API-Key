package com.SpringAI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiApplication.class, args);
	}

	@Bean
	public ChatClient openAiChatClient(OpenAiChatModel chatModel){
		return ChatClient.create(chatModel);
	}

	@Bean
	public ChatClient geminiAiChatClient(GoogleGenAiChatModel chatModel){
		return ChatClient.create(chatModel);
	}
}
