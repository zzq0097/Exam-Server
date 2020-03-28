package com.zyg.exam.controller;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResDTO;
import com.zyg.exam.common.UserDTO;
import com.zyg.exam.model.User;
import com.zyg.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@RestController
public class TestController {
@Autowired
private UserService userService;
    @PostMapping("/login")
    public JsonBean login(String number,String password){
        return userService.isLogin(number,password);
    }

    @PutMapping("/updateUser")
    public JsonBean updateUser(UserDTO userDTO){
        System.out.println(userDTO.toString());
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public JsonBean deleteUser(ArrayList<Integer> ids){
        System.out.println(ids.size());
        for (int i=0;i<ids.size();i++){
            System.out.println(ids.get(i));
        }
        return userService.deleteUser(ids);
    }

    @PostMapping("/insertUser")
    public JsonBean insertUser(UserDTO userDTO){
        return userService.insertUser(userDTO);
    }

    @GetMapping("/selectUser")
    public ResDTO selectByRole(String role, String name){

        return userService.selectUser(name,role);
    }

    @GetMapping("/getCourse")
    public List<String> selectCourse(int id){
        return userService.selectCourse(id);
    }


}
