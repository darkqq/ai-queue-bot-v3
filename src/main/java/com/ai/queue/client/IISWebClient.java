package com.ai.queue.client;

import com.ai.queue.to.client.response.faculty.ClientFacultiesResponseTO;
import com.ai.queue.to.client.response.group.ClientGroupsResponseTO;
import com.ai.queue.to.client.response.schedule.ClientScheduleResponseTO;
import com.ai.queue.to.client.response.speciality.ClientSpecialitiesResponseTO;

public interface IISWebClient {
    ClientScheduleResponseTO getSchedule(String group);

    ClientGroupsResponseTO getGroups();

    ClientSpecialitiesResponseTO getSpecialties();

    ClientFacultiesResponseTO getFaculties();

}
