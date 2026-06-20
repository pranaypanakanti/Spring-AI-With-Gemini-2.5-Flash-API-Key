package com.springAi.studyPlanner;

import com.springAi.kafka.StudyPlanRequest;
import com.springAi.ratelimit.RateLimitResult;
import com.springAi.ratelimit.RateLimitService;
import com.springAi.studyPlanner.job.StudyPlanJobResponse;
import com.springAi.studyPlanner.job.StudyPlanJobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/study-plan")
public class StudyPlanController {

    private final StudyPlanJobService jobService;
    private final RateLimitService rateLimitService;

    public StudyPlanController(StudyPlanJobService jobService, RateLimitService rateLimitService) {
        this.jobService = jobService;
        this.rateLimitService = rateLimitService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> submit(
            @RequestParam String userId,
            @RequestBody StudyPlanRequest input) {

        RateLimitResult rl = rateLimitService.tryConsume(userId);
        if (!rl.allowed()) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .header("Retry-After", String.valueOf(rl.retryAfterSeconds()))
                    .body(Map.of(
                            "error", "Rate limit exceeded",
                            "retryAfterSeconds", String.valueOf(rl.retryAfterSeconds())));
        }

        String jobId = jobService.submit(userId, input);

        return ResponseEntity.accepted()
                .header("X-Rate-Limit-Remaining", String.valueOf(rl.remainingTokens()))
                .body(Map.of("jobId", jobId));
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<StudyPlanJobResponse> getJob(@PathVariable String jobId) {
        return jobService.findJob(jobId)
                .map(StudyPlanJobResponse::from)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}