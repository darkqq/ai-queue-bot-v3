package com.ai.queue.service.update;

import com.ai.queue.client.IISWebClient;
import com.ai.queue.entity.FacultyEntity;
import com.ai.queue.entity.GroupEntity;
import com.ai.queue.entity.SpecialityEntity;
import com.ai.queue.repository.FacultyRepository;
import com.ai.queue.repository.GroupRepository;
import com.ai.queue.repository.SpecialityRepository;
import com.ai.queue.to.client.response.faculty.ClientFacultiesResponseTO;
import com.ai.queue.to.client.response.faculty.ClientFacultyTO;
import com.ai.queue.to.client.response.group.ClientGroupTO;
import com.ai.queue.to.client.response.group.ClientGroupsResponseTO;
import com.ai.queue.to.client.response.speciality.ClientSpecialitiesResponseTO;
import com.ai.queue.to.client.response.speciality.ClientSpecialityTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InfoUpdateServiceImpl implements InfoUpdateService {

    private final IISWebClient webClient;

    private final FacultyRepository facultyRepository;
    private final GroupRepository groupRepository;
    private final SpecialityRepository specialityRepository;

    @Override
    public void updateGroups() {
        ClientGroupsResponseTO groups = webClient.getGroups();
        for (ClientGroupTO group : groups.getGroups()) {
            GroupEntity groupEntity = new GroupEntity();
            groupEntity.setCourse(group.getCourse());
           /* groupEntity.setId(group.getId());*/
            groupEntity.setName(group.getName());
            groupEntity.setFacultyId(group.getFacultyId());
            groupEntity.setSpecialityId(group.getSpecialityDepartmentEducationFormId());
            groupRepository.saveAndFlush(groupEntity);
        }
    }

    @Override
    public void updateFaculties() {
        ClientFacultiesResponseTO faculties = webClient.getFaculties();
        for (ClientFacultyTO faculty : faculties.getFaculties()) {
            FacultyEntity facultyEntity = new FacultyEntity(
                    faculty.getId(),
                    faculty.getName(),
                    faculty.getAbbrev()
            );
            facultyRepository.saveAndFlush(facultyEntity);
        }
    }

    @Override
    public void updateSpecialities() {
        ClientSpecialitiesResponseTO specialties = webClient.getSpecialties();
        for (ClientSpecialityTO speciality : specialties.getSpecialities()) {
            SpecialityEntity specialityEntity = new SpecialityEntity(
                    speciality.getId(),
                    speciality.getName(),
                    speciality.getAbbrev(),
                    speciality.getEducationForm().getId(),
                    speciality.getEducationForm().getName(),
                    speciality.getFacultyId(),
                    speciality.getCode()
            );
            specialityRepository.saveAndFlush(specialityEntity);
        }
    }

    @Override
    public void updateSchedule() {

    }
}
