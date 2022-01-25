package com.ai.queue.controller;

import com.ai.queue.sec.annotation.SecuredRestController;
import com.ai.queue.sec.temp.Wrapper;
import com.ai.queue.service.student.StudentService;
import com.ai.queue.service.update.InfoUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SecuredRestController(wrapper = Wrapper.class)
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final InfoUpdateService updateService;


    @GetMapping("/test")
    public void test(){
/*        updateService.updateFaculties();
        updateService.updateGroups();
        updateService.updateSpecialities();*/
    }
}
