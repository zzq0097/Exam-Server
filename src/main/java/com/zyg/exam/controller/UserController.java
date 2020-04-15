package com.zyg.exam.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.exam.common.DTO.AdminDTO;
import com.zyg.exam.common.DTO.StudentDTO;
import com.zyg.exam.common.DTO.TeacherDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.User;
import com.zyg.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-15
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public JsonBean login(String username, String password){
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        map.put("username",username);
        map.put("password",password);
        queryWrapper.allEq(map);
        List<User> list = userService.list(queryWrapper);
        if (list.size() == 1 && (list.get(0).getRole().equals("1") || list.get(0).getRole().equals("2"))){
            list.get(0).setPassword("");
            return new JsonBean(200,"登录成功",list.get(0));
        } else {
            return new JsonBean(500,"登录失败",null);
        }
    }

    @RequestMapping("/selectStudent")
    public ResVO selectStudent(StudentDTO studentDTO){

        return userService.selectStudent(studentDTO);
    }
    @RequestMapping("/selectTeacher")
    public ResVO selectTeacher(TeacherDTO teacherDTO){
        Page<User> page = new Page<>(teacherDTO.getPageIndex(),teacherDTO.getPageSize());
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        map.put("role",2);
        if (StringUtils.isNotBlank(teacherDTO.getName())){
            map.put("name",teacherDTO.getName());
        }
        queryWrapper.allEq(map);
        IPage<User> list = userService.page(page,queryWrapper);
        return new ResVO(list.getRecords(),list.getTotal());
    }
    @RequestMapping("/selectAdmin")
    public ResVO selectAdmin(AdminDTO adminDTO){
        Page<User> page = new Page<>(adminDTO.getPageIndex(),adminDTO.getPageSize());
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        map.put("role",1);
        queryWrapper.allEq(map);
        IPage<User> list = userService.page(page,queryWrapper);
        return new ResVO(list.getRecords(),list.getTotal());
    }
    // 公共接口
    @RequestMapping("/updateUser")
    public JsonBean updateUser(User user){
        return new JsonBean(200,"success",userService.updateById(user));
    }
    @RequestMapping("/insertUser")
    public JsonBean insertUser(User user){
        return new JsonBean(200,"success",userService.save(user));
    }
    @RequestMapping("/deleteUser")
    public JsonBean deleteUser(@RequestParam(value = "ids") List<Integer> ids){
        return new JsonBean(200,"success",userService.removeByIds(ids));
    }
}

