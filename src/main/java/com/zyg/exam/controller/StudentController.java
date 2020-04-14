package com.zyg.exam.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.exam.common.DTO.StudentDTO;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Student;
import com.zyg.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-14
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/selectStudent")
    public ResVO selectStudent(StudentDTO studentDTO){
        Page<Student> page = new Page<>(studentDTO.getPageIndex(),studentDTO.getPageSize());
        if (studentDTO.getClassid() != null){
            QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
            Map<String, Integer> map = new HashMap<>();
            map.put("classid",studentDTO.getClassid());
            queryWrapper.allEq(map);
        }
        IPage<Student> list = studentService.page(page,null);
        return new ResVO(list.getRecords(),list.getTotal());
    }
}

