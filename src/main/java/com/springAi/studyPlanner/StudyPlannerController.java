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
    public StudyPlanResponse studyPlanner(@RequestParam(value = "topic", defaultValue = "Java") String topic,
                                          @RequestParam(value = "timeAvailable", defaultValue = "One Month") String timeAvailable,
                                          @RequestParam(value = "purpose", defaultValue = "Learning") String purpose,
                                          @RequestParam(value = "level", defaultValue = "Intermediate") String level,
                                          @RequestParam(value = "notes", defaultValue = "none") String notes) {
        return studyPlanService.studyPlanner(topic, timeAvailable, purpose, level, notes);

    }
}

