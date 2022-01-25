package com.ai.queue.to.client.response.faculty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientFacultiesResponseTO {
    private List<ClientFacultyTO> faculties;
}
