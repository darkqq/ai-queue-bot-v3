package com.ai.queue.to.client.response.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientGroupTO {
    private String name;
    private Integer facultyId;
    private Integer specialityDepartmentEducationFormId;
    private Integer course;
    private Integer id;
}
