package com.zyg.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyg.exam.common.DTO.ChapterDTO;
import com.zyg.exam.common.DTO.CourseDTO;
import com.zyg.exam.common.VO.CourseVO;
import com.zyg.exam.common.VO.OptionVO;
import com.zyg.exam.model.Chapter;
import com.zyg.exam.model.Course;
import com.zyg.exam.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseDao extends BaseMapper<Course> {
    int deleteByPrimaryKey(int[] courseids);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<List<Object>> listCourse(CourseDTO courseDTO);

    List<List<Object>> selectChapter(ChapterDTO chapterDTO);

    List<Object> selectQuestion(Integer courseid);

    int importCourse(CourseVO courseVO);

    List<OptionVO> selectCourse(Integer id);
}