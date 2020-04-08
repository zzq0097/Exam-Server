package com.zyg.exam.controller;

import com.zyg.exam.common.DTO.UserDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.User;
import com.zyg.exam.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public JsonBean login(String username,String password){
        return userService.isLogin(username,password);
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
            return new JsonBean(200,"未选择条目：删除了0条数据",null);
        }
    }

    @PostMapping("/insertUser")
    public JsonBean insertUser(User user){
        return userService.insertUser(user);
    }

    @GetMapping("/selectUser")
    public ResVO selectByRole(UserDTO userDTO){
        return userService.selectUser(userDTO);
    }

    @GetMapping("/getCourse")
    public List<String> selectCourse(int id){
        return userService.selectCourse(id);
    }

    @PostMapping("/importUser")
    public JsonBean addQuestion(@RequestParam("file") MultipartFile file){
        JsonBean jsonBean=new JsonBean();
        String fileName = file.getOriginalFilename();
        log.info("{}",fileName);
        try {
            jsonBean=userService.batchImport(fileName,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  jsonBean;
    }
}
