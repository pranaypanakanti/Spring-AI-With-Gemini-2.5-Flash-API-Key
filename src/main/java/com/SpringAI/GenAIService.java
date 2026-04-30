package com.SpringAI;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

@Service
public class GenAIService {

    public String getResponse(String prompt){

        Client client = new Client();

        GenerateContentConfig config =
                GenerateContentConfig.builder()
                        .temperature(0.3F)
                        .maxOutputTokens(900)
                        .build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash-lite",
                        prompt,
                        null);

        return response.text();
    }
}
