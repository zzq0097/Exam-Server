package com.zyg.exam.controller;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.model.Class;
import com.zyg.exam.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/selectStudentInClass")
    public JsonBean selectStudent(int classId){
        return classService.selectStudentInClass(classId);
    }

    @GetMapping("/selectTeachInfo")
    public JsonBean selectTeachInfo(int classId){
        return classService.selectTeachInfo(classId);
    }

    @GetMapping("/getClassList")
    public List<Class> listClass(){
        return classService.listClass();
    }

    @PostMapping("/deleteClass")
    public JsonBean deleteClass(int[] ids){
        return classService.deleteClass(ids);
    }
}
