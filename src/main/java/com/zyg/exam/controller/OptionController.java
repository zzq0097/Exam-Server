package com.zyg.exam.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyg.exam.common.VO.OptionVO;
import com.zyg.exam.dao.ChapterDao;
import com.zyg.exam.dao.ClassDao;
import com.zyg.exam.dao.CourseDao;
import com.zyg.exam.model.Course;
import com.zyg.exam.model.User;
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

    @RequestMapping("/teacherOption")
    public List<OptionVO> teacherOption(){
        List<OptionVO> list = new ArrayList<>();
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
        if (id == null){
            for (Course course: courseDao.selectList(null)) {
                OptionVO optionVO = new OptionVO(course.getCourseid(),course.getCoursename());
                list.add(optionVO);
            }
        }
        return list;
    }
    @RequestMapping("/chapterOption")
    public List<OptionVO> chapterOption(Integer id){
        List<OptionVO> list = new ArrayList<>();
        if (id == null){
            for (Course course: courseDao.selectList(null)) {
                OptionVO optionVO = new OptionVO(course.getCourseid(),course.getCoursename());
                list.add(optionVO);
            }
        }
        return list;
    }
    @RequestMapping("/classOption")
    public List<OptionVO> classOption(Integer id){
        List<OptionVO> list = new ArrayList<>();
        if (id == null){
            for (Course course: courseDao.selectList(null)) {
                OptionVO optionVO = new OptionVO(course.getCourseid(),course.getCoursename());
                list.add(optionVO);
            }
        }
        return list;
    }
}
