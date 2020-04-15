package com.zyg.exam.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.exam.common.DTO.TeacherDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Teacher;
import com.zyg.exam.model.Teacher;
import com.zyg.exam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-15
 */
@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/selectTeacher")
    public ResVO selectTeacher(TeacherDTO teacherDTO){
        Page<Teacher> page = new Page<>(teacherDTO.getPageIndex(),teacherDTO.getPageSize());
        QueryWrapper<Teacher> queryWrapper = null;
        if (StringUtils.isNotBlank(teacherDTO.getName())){
            queryWrapper = new QueryWrapper<>();
            Map<String, String> map = new HashMap<>();
            map.put("name",teacherDTO.getName());
            queryWrapper.allEq(map);
        }
        IPage<Teacher> list = teacherService.page(page,queryWrapper);
        return new ResVO(list.getRecords(),list.getTotal());
    }
    @RequestMapping("/updateTeacher")
    public JsonBean updateTeacher(Teacher teacher){
        return new JsonBean(200,"success",teacherService.updateById(teacher));
    }
    @RequestMapping("/insertTeacher")
    public JsonBean insertTeacher(Teacher teacher){
        return new JsonBean(200,"success",teacherService.save(teacher));
    }
    @RequestMapping("/deleteTeacher")
    public JsonBean deleteTeacher(@RequestParam(value = "ids")List<Integer> ids){
        return new JsonBean(200,"success",teacherService.removeByIds(ids));
    }
}

