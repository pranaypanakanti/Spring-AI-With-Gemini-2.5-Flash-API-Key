package com.springAi.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudyPlanProducer {

    private static final Logger log = LoggerFactory.getLogger(StudyPlanProducer.class);
    private static final String TOPIC = "study-plan-jobs";

    private final KafkaTemplate<String, StudyPlanRequest> kafkaTemplate;

    public StudyPlanProducer(KafkaTemplate<String, StudyPlanRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String userId, StudyPlanRequest request) {
        kafkaTemplate.send(TOPIC, userId, request)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to send message: {}", ex.getMessage());
                    } else {
                        log.info("Sent → key={} partition={} offset={}",
                                userId,
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    }
                });
    }
}