package com.ai.queue.to.controller.response.iis.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialitiesResponseTO {
    private List<SpecialityTO> specialities;
}
