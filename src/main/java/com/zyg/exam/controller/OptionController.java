package com.zyg.exam.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyg.exam.common.VO.OptionVO;
import com.zyg.exam.common.VO.TeachOptionVO;
import com.zyg.exam.dao.ChapterDao;
import com.zyg.exam.dao.ClassDao;
import com.zyg.exam.dao.CourseDao;
import com.zyg.exam.dao.TeachDao;
import com.zyg.exam.model.*;
import com.zyg.exam.model.Class;
import com.zyg.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OptionController {
    @Autowired
    private UserService userService;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private TeachDao teachDao;

    @RequestMapping("/teacherOption")
    public List<OptionVO> teacherOption(Integer id){
        List<OptionVO> list = new ArrayList<>();

        if (id != null) {
            // TODO 根据courseid 查找teacher 的 OptionVO
            return list;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role",2);
        for (User user: userService.list(queryWrapper)) {
            OptionVO optionVO = new OptionVO(user.getId(),user.getName());
            list.add(optionVO);
        }
        return list;
    }
    @RequestMapping("/courseOption")
    public List<OptionVO> courseOption(Integer id){
        List<OptionVO> list = new ArrayList<>();
        if (id != null){
            // TODO 根据 teacherid 查询 所教课程 的 OptionVO
            return list;
        }

        for (Course course: courseDao.selectList(null)) {
            OptionVO optionVO = new OptionVO(course.getCourseid(),course.getCoursename());
            list.add(optionVO);
        }
        return list;
    }
    @RequestMapping("/chapterOption")
    public List<OptionVO> chapterOption(Integer id){
        List<OptionVO> list = new ArrayList<>();
        QueryWrapper<Chapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("courseid",id);
        for (Chapter chapter: chapterDao.selectList(null)) {
            OptionVO optionVO = new OptionVO(chapter.getChapterid(),chapter.getChaptername());
            list.add(optionVO);
        }
        return list;
    }
    @RequestMapping("/classOption")
    public List<OptionVO> classOption(Integer id){
        List<OptionVO> list = new ArrayList<>();
        for (Class entity: classDao.selectList(null)) {
            OptionVO optionVO = new OptionVO(entity.getClassid(),entity.getClassname());
            list.add(optionVO);
        }
        return list;
    }
    @RequestMapping("/teachOption")
    public List<TeachOptionVO> teachOption(){
        List<TeachOptionVO> list = null;
        return list;
    }
}
