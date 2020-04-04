package com.zyg.exam.controller;

import com.zyg.exam.common.DTO.ChapterDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Course;
import com.zyg.exam.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourseList")
    public List<Course> listCourse(){
        return courseService.listCourse();
    }

    @PutMapping("/insertCourse")
    public JsonBean insertCourse(Course course){
        return courseService.insertCourse(course);
    }

    @PostMapping("/updateCourse")
    public JsonBean updateCourse(Course course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/deleteCourse")
    public JsonBean deleteCourse(int courseid){
        return courseService.deleteCourse(courseid);
    }

    @GetMapping("/listChapter")
    public ResVO getChapter(ChapterDTO chapterDTO){
        return courseService.selectChapter(chapterDTO);
    }
}
