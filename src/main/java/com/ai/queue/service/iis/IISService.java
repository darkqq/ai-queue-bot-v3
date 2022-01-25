package com.ai.queue.service.iis;

import com.ai.queue.to.controller.response.iis.faculty.FacultiesResponseTO;
import com.ai.queue.to.controller.response.iis.groups.GroupsResponseTO;
import com.ai.queue.to.controller.response.iis.spec.SpecialitiesResponseTO;

public interface IISService {

    GroupsResponseTO getGroupsBySpecId(Integer specId);

    FacultiesResponseTO getFaculties();

    SpecialitiesResponseTO getSpecialitiesByFacultyId(Integer facultyId);
}
