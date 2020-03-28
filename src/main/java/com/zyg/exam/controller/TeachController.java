package com.zyg.exam.controller;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.model.Teach;
import com.zyg.exam.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeachController {
    @Autowired
    private TeachService teachService;

    @GetMapping("/listTeachInfo")
    public JsonBean listTeach(){
        return teachService.listTeachInfo();
    }

    @DeleteMapping("/deleteTeach")
    public JsonBean deleteTeach(int teachId){
        return teachService.deleteTeach(teachId);
    }

    @PostMapping("/insertTeach")
    public JsonBean insertTeach(Teach teach){
        return teachService.insertTeach(teach);
    }

    @PostMapping("/updateTeach")
    public JsonBean updateTeach(Teach teach){
        return teachService.updateTeach(teach);
    }

}
