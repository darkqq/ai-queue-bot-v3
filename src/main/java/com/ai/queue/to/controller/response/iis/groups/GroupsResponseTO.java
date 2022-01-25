package com.ai.queue.to.controller.response.iis.groups;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupsResponseTO {
    private List<String> groups;
}
