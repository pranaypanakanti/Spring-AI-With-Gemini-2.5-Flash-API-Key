package com.springAi.studyPlanner;

import com.springAi.studyPlanner.entities.StudyPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/study")
public class StudyPlannerController {

    @Autowired
    private StudyPlanService studyPlanService;

    @GetMapping("/plan")
    public StudyPlanResponse studyPlanner(@RequestParam(value = "topic", defaultValue = "Kafka") String topic,
                                          @RequestParam(value = "timeAvailable", defaultValue = "2 weeks") String timeAvailable,
                                          @RequestParam(value = "purpose", defaultValue = "Interview") String purpose,
                                          @RequestParam(value = "level", defaultValue = "Beginner") String level,
                                          @RequestParam(value = "notes", defaultValue = "none") String notes) {
        return studyPlanService.studyPlanner(topic, timeAvailable, purpose, level, notes);

    }
}

