package com.springAi.kafka;

import com.springAi.studyPlanner.job.StudyPlanJob;
import com.springAi.studyPlanner.job.StudyPlanJobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class StudyPlanConsumer {

    private static final Logger log = LoggerFactory.getLogger(StudyPlanConsumer.class);

    private final StudyPlanJobRepository jobRepository;

    public StudyPlanConsumer(StudyPlanJobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @KafkaListener(
            topics = "study-plan-jobs",
            groupId = "study-plan-group",
            concurrency = "2"
    )
    public void consume(StudyPlanJobMessage message,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {

        log.info("Received job {} on partition {}", message.getJobId(), partition);

        StudyPlanJob job = jobRepository.findByJobId(message.getJobId()).orElse(null);
        if (job == null) {
            log.error("No job found in Mongo for jobId {}", message.getJobId());
            return;
        }

        log.info("Loaded job {} → status={} topic={}",
                job.getJobId(), job.getStatus(), job.getInput().getTopic());

        // Step 4 will add: status → PROCESSING, call Gemini, assign IDs, save DONE/FAILED
    }
}