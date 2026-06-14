package com.springAi.kafka;

import com.springAi.studyPlanner.StudyPlanService;
import com.springAi.studyPlanner.entities.StudyPlanResponse;
import com.springAi.studyPlanner.job.JobStatus;
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

    private final StudyPlanService studyPlanService;

    public StudyPlanConsumer(StudyPlanJobRepository jobRepository, StudyPlanService studyPlanService) {
        this.jobRepository = jobRepository;
        this.studyPlanService = studyPlanService;
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
            log.error("No job found in MongoDB for jobId {}", message.getJobId());
            return;
        }

        log.info("Loaded job {} → status={} topic={}",
                job.getJobId(), job.getStatus(), job.getInput().getTopic());

        job.setStatus(JobStatus.PROCESSING);

        StudyPlanRequest input = job.getInput();

        StudyPlanResponse response = studyPlanService.studyPlanner(
                input.getTopic(),
                input.getTimeAvailable(),
                input.getPurpose(),
                input.getLevel(),
                input.getNotes()
        );

        if(response != null) {
            job.setPlan(response);
            job.setStatus(JobStatus.DONE);
        } else {
            job.setStatus(JobStatus.FAILED);
        }


        // Step 4 will assign IDs for all sub topics and count them
    }
}