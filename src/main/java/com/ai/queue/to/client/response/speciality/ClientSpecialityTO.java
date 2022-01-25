package com.ai.queue.to.client.response.speciality;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientSpecialityTO {
    private Integer id;
    private String name;
    private String abbrev;
    private EducationForm educationForm;
    private Integer facultyId;
    private String code;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EducationForm {
        private Integer id;
        private String name;
    }
}
