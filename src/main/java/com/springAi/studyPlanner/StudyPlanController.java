package com.springAi.studyPlanner;

import com.springAi.kafka.StudyPlanRequest;
import com.springAi.studyPlanner.job.StudyPlanJobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/study-plan")
public class StudyPlanController {

    private final StudyPlanJobService jobService;

    public StudyPlanController(StudyPlanJobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> submit(
            @RequestParam(defaultValue = "user-1") String userId,
            @RequestBody StudyPlanRequest input) {

        String jobId = jobService.submit(userId, input);

        return ResponseEntity.accepted().body(Map.of("jobId", jobId));
    }
}