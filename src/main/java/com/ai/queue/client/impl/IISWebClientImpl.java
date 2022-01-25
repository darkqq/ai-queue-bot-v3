package com.ai.queue.client.impl;

import ch.qos.logback.core.net.server.Client;
import com.ai.queue.client.IISWebClient;
import com.ai.queue.properties.ConfigPropertiesComponent;
import com.ai.queue.to.client.response.faculty.ClientFacultiesResponseTO;
import com.ai.queue.to.client.response.faculty.ClientFacultyTO;
import com.ai.queue.to.client.response.group.ClientGroupTO;
import com.ai.queue.to.client.response.group.ClientGroupsResponseTO;
import com.ai.queue.to.client.response.schedule.ClientScheduleResponseTO;
import com.ai.queue.to.client.response.speciality.ClientSpecialitiesResponseTO;
import com.ai.queue.to.client.response.speciality.ClientSpecialityTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IISWebClientImpl implements IISWebClient {

    @Qualifier("web-client-iis")
    private final WebClient webClient;

    private final ConfigPropertiesComponent configPropertiesComponent;

    private static final String STUDENT_GROUP = "studentGroup";

    @Override
    public ClientScheduleResponseTO getSchedule(String group) {
        return webClient
                .get()
                .uri(UriComponentsBuilder.fromHttpUrl(configPropertiesComponent.getIisApiBase())
                        .path(configPropertiesComponent.getIisSchedulePath())
                        .queryParam(STUDENT_GROUP, group)
                        .toUriString())
                .retrieve()
                .bodyToMono(ClientScheduleResponseTO.class)
                .block();
    }

    @Override
    public ClientGroupsResponseTO getGroups() {
        List<ClientGroupTO> groups = webClient
                .get()
                .uri(UriComponentsBuilder.fromHttpUrl(configPropertiesComponent.getIisApiBase())
                        .path(configPropertiesComponent.getIisGroupsPath())
                        .toUriString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ClientGroupTO>>() {})
                .block();
        return new ClientGroupsResponseTO(groups);
    }

    @Override
    public ClientSpecialitiesResponseTO getSpecialties() {
        List<ClientSpecialityTO> specialities = webClient
                .get()
                .uri(UriComponentsBuilder.fromHttpUrl(configPropertiesComponent.getIisApiBase())
                        .path(configPropertiesComponent.getIisSpecialitiesPath())
                        .toUriString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ClientSpecialityTO>>() {})
                .block();
        return new ClientSpecialitiesResponseTO(specialities);
    }

    @Override
    public ClientFacultiesResponseTO getFaculties() {
        List<ClientFacultyTO> faculties = webClient
                .get()
                .uri(UriComponentsBuilder.fromHttpUrl(configPropertiesComponent.getIisApiBase())
                        .path(configPropertiesComponent.getIisFacultiesPath())
                        .toUriString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ClientFacultyTO>>() {})
                .block();
        return new ClientFacultiesResponseTO(faculties);
    }
}
