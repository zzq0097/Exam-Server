package com.zyg.exam.dao;

import com.zyg.exam.model.Chapter;
import com.zyg.exam.model.Course;
import com.zyg.exam.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    int deleteByPrimaryKey(Integer courseid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> listCourse();

    List<Object> getChapterByCourseId(int courseid,int pageIndex,int pageSize);

    List<Object> selectQuestion(Integer courseid);
}