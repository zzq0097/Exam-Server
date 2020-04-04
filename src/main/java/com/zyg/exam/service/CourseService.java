package com.zyg.exam.service;

import com.zyg.exam.common.DTO.ChapterDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> listCourse();

    JsonBean insertCourse(Course course);

    JsonBean updateCourse(Course course);

    JsonBean deleteCourse(int courseid);

    ResVO selectChapter(ChapterDTO chapterDTO);

    JsonBean selectQuestion(Integer courseid);
}
