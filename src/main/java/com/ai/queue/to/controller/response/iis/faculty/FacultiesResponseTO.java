package com.ai.queue.to.controller.response.iis.faculty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultiesResponseTO {
    private List<FacultyTO> faculties;
}
