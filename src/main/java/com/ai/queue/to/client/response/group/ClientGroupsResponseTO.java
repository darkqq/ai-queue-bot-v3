package com.ai.queue.to.client.response.group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientGroupsResponseTO {
    private List<ClientGroupTO> groups;
}
