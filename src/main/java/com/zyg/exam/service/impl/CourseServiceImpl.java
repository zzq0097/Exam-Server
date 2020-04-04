package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.ChapterDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.CourseDao;
import com.zyg.exam.model.Course;
import com.zyg.exam.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> listCourse() {
        return courseDao.listCourse();
    }

    @Override
    public JsonBean insertCourse(Course course) {
        int num = courseDao.insertSelective(course);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"添加成功",null);
        }else {
            return new JsonBean(500,"添加失败",null);
        }
    }

    @Override
    public JsonBean updateCourse(Course course) {
        int num = courseDao.updateByPrimaryKeySelective(course);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"修改成功",null);
        }else {
            return new JsonBean(500,"修改失败",null);
        }
    }

    @Override
    public JsonBean deleteCourse(int courseid) {
        int num = courseDao.deleteByPrimaryKey(courseid);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"删除成功",null);
        }else {
            return new JsonBean(500,"删除失败",null);
        }
    }

    @Override
    public ResVO selectChapter(ChapterDTO chapterDTO) {
        List<Object> chapters=courseDao.selectChapter(chapterDTO).get(0);
        long count = (long)courseDao.selectChapter(chapterDTO).get(1).get(0);
        return new ResVO(chapters,count);
    }

    @Override
    public JsonBean selectQuestion(Integer courseid) {
        List<Object> questions = courseDao.selectQuestion(courseid);
        if (questions.size()>0){
            return new JsonBean(HttpStatus.OK.value(),"",questions);
        }else {
            return new JsonBean(500,"没有相关信息",null);
        }
    }
}
