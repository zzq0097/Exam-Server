package com.zyg.exam.controller;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResDTO;
import com.zyg.exam.model.User;
import com.zyg.exam.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class TestController {
@Autowired
private UserService userService;
    @PostMapping("/login")
    public JsonBean login(String number,String password){
        return userService.isLogin(number,password);
    }

    @PutMapping("/updateUser")
    public JsonBean updateUser(User user){
        return userService.updateUser(user);
    }

    @PostMapping("/deleteUser")
    public JsonBean deleteUser(int[] ids){
        if (ids.length>0){
            return userService.deleteUser(ids);
        } else {
            return new JsonBean(200,null,"未选择条目：删除了0条数据");
        }
    }

    @PostMapping("/insertUser")
    public JsonBean insertUser(User user){
        return userService.insertUser(user);
    }

    @GetMapping("/selectUser")
    public ResDTO selectByRole(String role, String name, Integer pageIndex, Integer pageSize){
        return userService.selectUser(name,role,pageIndex,pageSize);
    }

    @GetMapping("/getCourse")
    public List<String> selectCourse(int id){
        return userService.selectCourse(id);
    }
}
