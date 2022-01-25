package com.ai.queue.controller;

import com.ai.queue.service.iis.IISService;
import com.ai.queue.to.controller.response.iis.faculty.FacultiesResponseTO;
import com.ai.queue.to.controller.response.iis.groups.GroupsResponseTO;
import com.ai.queue.to.controller.response.iis.spec.SpecialitiesResponseTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/iis")
@RequiredArgsConstructor
public class IISInfoController {
    private final IISService iisService;

    @GetMapping(value = "/faculties", produces = "application/json")
    public ResponseEntity<FacultiesResponseTO> getFaculties(){
            return ResponseEntity.ok(iisService.getFaculties());
    }

    @GetMapping(value = "/specialities", produces = "application/json")
    public ResponseEntity<SpecialitiesResponseTO> getSpecialitiesByFaculty(@RequestParam Integer facultyId){
        return ResponseEntity.ok(iisService.getSpecialitiesByFacultyId(facultyId));
    }

    @GetMapping(value = "/groups", produces = "application/json")
    public ResponseEntity<GroupsResponseTO> getGroupsBySpeciality(@RequestParam Integer specialityId){
        return ResponseEntity.ok(iisService.getGroupsBySpecId(specialityId));
    }


}
