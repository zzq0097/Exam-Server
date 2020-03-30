package com.zyg.exam.dao;

import com.zyg.exam.model.Chapter;
import com.zyg.exam.model.Course;
import com.zyg.exam.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseDao {
    int deleteByPrimaryKey(Integer courseid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> listCourse();

    List<List<Object>> getChapterByCourseId(Map<String,Object> param);

    List<Object> selectQuestion(Integer courseid);
}