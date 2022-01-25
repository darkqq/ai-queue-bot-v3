package com.ai.queue.to.client.response.faculty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientFacultyTO {
    private Integer id;
    private String name;
    private String abbrev;
}
