package com.zyg.exam.controller;

import com.zyg.exam.common.DTO.ChapterDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Course;
import com.zyg.exam.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Slf4j
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/getCourseList")
    public List<Course> listCourse(){
        return courseService.listCourse();
    }

    @RequestMapping("/insertCourse")
    public JsonBean insertCourse(Course course){
        return courseService.insertCourse(course);
    }

    @RequestMapping("/updateCourse")
    public JsonBean updateCourse(Course course){
        return courseService.updateCourse(course);
    }

    @RequestMapping("/deleteCourse")
    public JsonBean deleteCourse(int[] courseids){
        System.out.println(courseids);
        return courseService.deleteCourse(courseids);
    }

    @RequestMapping("/listChapter")
    public ResVO getChapter(ChapterDTO chapterDTO){
        return courseService.selectChapter(chapterDTO);
    }

    @RequestMapping("/importCourse")
    public JsonBean addQuestion(@RequestParam("file") MultipartFile file){
        JsonBean jsonBean=new JsonBean();
        String fileName = file.getOriginalFilename();
        log.info("{}",fileName);
        try {
            jsonBean=courseService.batchImport(fileName,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  jsonBean;
    }
}
