package com.ai.queue.to.client.response.speciality;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientSpecialitiesResponseTO {
    private List<ClientSpecialityTO> specialities;
}
