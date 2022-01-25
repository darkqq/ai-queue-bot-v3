package com.ai.queue.to.client.response.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleWrapperTO {
    private String weekDay;
    private List<ScheduleTO> schedule;
}