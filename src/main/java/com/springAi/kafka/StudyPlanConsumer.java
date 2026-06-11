package com.springAi.kafka;

import com.springAi.studyPlanner.StudyPlanService;
import com.springAi.studyPlanner.entities.StudyPlanResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class StudyPlanConsumer {

    private static final Logger log = LoggerFactory.getLogger(StudyPlanConsumer.class);

    private final StudyPlanService studyPlanService;

    public StudyPlanConsumer(StudyPlanService studyPlanService) {
        this.studyPlanService = studyPlanService;
    }

    @KafkaListener(
            topics = "study-plan-jobs",
            groupId = "study-plan-group",
            concurrency = "2"
    )
    public void consume(StudyPlanRequest request,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {

        log.info("Received on partition {}: {}", partition, request);

        StudyPlanResponse response = studyPlanService.studyPlanner(
                request.getTopic(),
                request.getTimeAvailable(),
                request.getPurpose(),
                request.getLevel(),
                request.getNotes()
        );

        log.info("Plan generated on partition {}: goal={}",
                partition, response.getGoalOverview().getTopic());
    }
}