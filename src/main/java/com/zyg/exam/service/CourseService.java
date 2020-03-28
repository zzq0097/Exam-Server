package com.zyg.exam.service;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResDTO;
import com.zyg.exam.model.Chapter;
import com.zyg.exam.model.Course;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface CourseService {

    List<Course> listCourse();

    JsonBean insertCourse(Course course);

    JsonBean updateCourse(Course course);

    JsonBean deleteCourse(int courseid);

    ResDTO selectChapter(Integer courseid, int pageIndex, int pageSize);

    JsonBean selectQuestion(Integer courseid);
}
