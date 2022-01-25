package com.ai.queue.to.client.response.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentGroup{
    private String name;
    private Integer facultyId;
    private Object facultyName;
    private Integer specialityDepartmentEducationFormId;
    private Integer course;
    private Integer id;
}