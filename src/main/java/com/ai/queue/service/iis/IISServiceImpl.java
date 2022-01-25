package com.ai.queue.service.iis;

import com.ai.queue.entity.FacultyEntity;
import com.ai.queue.entity.GroupEntity;
import com.ai.queue.entity.SpecialityEntity;
import com.ai.queue.repository.FacultyRepository;
import com.ai.queue.repository.GroupRepository;
import com.ai.queue.repository.SpecialityRepository;
import com.ai.queue.to.controller.response.iis.faculty.FacultiesResponseTO;
import com.ai.queue.to.controller.response.iis.faculty.FacultyTO;
import com.ai.queue.to.controller.response.iis.groups.GroupsResponseTO;
import com.ai.queue.to.controller.response.iis.spec.SpecialitiesResponseTO;
import com.ai.queue.to.controller.response.iis.spec.SpecialityTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class IISServiceImpl implements IISService {
    private final FacultyRepository facultyRepository;
    private final SpecialityRepository specialityRepository;
    private final GroupRepository groupRepository;

    @Override
    public GroupsResponseTO getGroupsBySpecId(Integer specId) {
        GroupsResponseTO response = new GroupsResponseTO();
        response.setGroups(new ArrayList<>());
        for (GroupEntity groupEntity : groupRepository.findAllBySpecialityId(specId)) {
            response.getGroups().add(groupEntity.getName());
        }

        return response;
    }

    @Override
    public FacultiesResponseTO getFaculties() {
        FacultiesResponseTO response = new FacultiesResponseTO();
        response.setFaculties(new ArrayList<>());
        for (FacultyEntity facultyEntity : facultyRepository.findAll()) {
            response.getFaculties().add(new FacultyTO(facultyEntity.getName(), facultyEntity.getCypher(), facultyEntity.getId()));
        }
        return response;
    }

    @Override
    public SpecialitiesResponseTO getSpecialitiesByFacultyId(Integer facultyId) {
        SpecialitiesResponseTO response = new SpecialitiesResponseTO(new ArrayList<>());
        for (SpecialityEntity specialityEntity : specialityRepository.findAllByFacultyId(facultyId)) {
            response.getSpecialities().add(new SpecialityTO(specialityEntity.getName(), specialityEntity.getAbbrev(), specialityEntity.getId()));
        }
        return response;
    }
}
