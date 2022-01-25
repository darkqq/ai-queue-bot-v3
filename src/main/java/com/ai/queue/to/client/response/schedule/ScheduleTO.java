package com.ai.queue.to.client.response.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleTO {
    private List<Integer> weekNumber;
    private List<String> studentGroup;
    private Integer numSubgroup;
    private String lessonTime;
    private String startLessonTime;
    private String endLessonTime;
    private String subject;
    private String lessonType;
}