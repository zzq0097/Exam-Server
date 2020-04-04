package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.ChapterDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.ChapterDao;
import com.zyg.exam.dao.CourseDao;
import com.zyg.exam.model.Chapter;
import com.zyg.exam.model.Course;
import com.zyg.exam.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
@Autowired
private CourseDao courseDao;
@Autowired
private ChapterDao chapterDao;
    @Override
    public List<Course> listCourse() {
        return courseDao.listCourse();

    }

    @Override
    public JsonBean insertCourse(Course course) {
        int num = courseDao.insertSelective(course);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"添加成功");
        }else {
            return new JsonBean(500,null,"添加失败");
        }
    }

    @Override
    public JsonBean updateCourse(Course course) {
        int num = courseDao.updateByPrimaryKeySelective(course);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"修改成功");
        }else {
            return new JsonBean(500,null,"修改失败");
        }
    }

    @Override
    public JsonBean deleteCourse(int courseid) {
        int num = courseDao.deleteByPrimaryKey(courseid);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"删除成功");
        }else {
            return new JsonBean(500,null,"删除失败");
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
            return new JsonBean(HttpStatus.OK.value(),questions,"");
        }else {
            return new JsonBean(500,null,"没有相关信息");
        }
    }
}
