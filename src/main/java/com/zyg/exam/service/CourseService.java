package com.zyg.exam.service;

import com.zyg.exam.common.DTO.ChapterDTO;
import com.zyg.exam.common.DTO.CourseDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {

    ResVO listCourse(CourseDTO courseDTO);

    JsonBean insertCourse(Course course);

    JsonBean updateCourse(Course course);

    JsonBean deleteCourse(int[] courseids);

    ResVO selectChapter(ChapterDTO chapterDTO);

    JsonBean selectQuestion(Integer courseid);

    JsonBean batchImport(String fileName, MultipartFile file) throws Exception;
}
