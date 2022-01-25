package com.ai.queue.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Data
@Component
public class ConfigPropertiesComponent {
    @Value("${path.iis.api.base}")
    private String iisApiBase;
    @Value("${path.iis.api.schedule}")
    private String iisSchedulePath;
    @Value("${path.iis.api.groups}")
    private String iisGroupsPath;
    @Value("${path.iis.api.faculties}")
    private String iisFacultiesPath;
    @Value("${path.iis.api.specialities}")
    private String iisSpecialitiesPath;
}