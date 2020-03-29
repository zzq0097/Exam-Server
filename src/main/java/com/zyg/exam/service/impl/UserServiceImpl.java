package com.zyg.exam.service.impl;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResDTO;
import com.zyg.exam.common.UserDTO;
import com.zyg.exam.dao.UserDao;
import com.zyg.exam.model.User;
import com.zyg.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public JsonBean isLogin(String number, String password) {
        String pass = userDao.login(number);
        boolean flag = false;
        if (pass.equals(password)){
            flag=true;
            return new JsonBean(HttpStatus.OK.value(),null,"登录成功");
        }else {
            return new JsonBean(0,null,"登录失败");
        }

    }

    @Override
    public JsonBean updateUser(User user) {
        int num=userDao.updateByPrimaryKeySelective(user);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"更新成功");
        }else {
            return new JsonBean(500,null,"更新失败");
        }
    }

    @Override
    public JsonBean deleteUser(int[] ids) {
        return new JsonBean(200,null,"删除了"+userDao.deleteByPrimaryKey(ids)+"条数据");
    }

    @Override
    public JsonBean insertUser(User user) {
        int num = userDao.insertSelective(user);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"插入成功");
        }else {
            return new JsonBean(500,null,"插入失败");
        }
    }

    @Override
    public ResDTO selectUser(String name, String role,Integer pageIndex,Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("name",name);
        params.put("role",role);
        params.put("pageIndex",(pageIndex-1)*pageSize);
        params.put("pageSize",pageSize);
        List<Object> users = userDao.selectUser(params).get(0);
        long count = (long)userDao.selectUser(params).get(1).get(0);
        int total = (int)count;
        return new ResDTO(users,total);
    }

    @Override
    public List<String> selectCourse(int id) {
        return userDao.selectCourse(id);
    }
}
