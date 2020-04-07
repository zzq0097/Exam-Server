package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.UserDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.UserDao;
import com.zyg.exam.model.User;
import com.zyg.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public JsonBean isLogin(String username, String password) {
        List<User> user = userDao.login(username,password);
        if ( user.size() == 1){
            return new JsonBean(200,"登录成功",user.get(0));
        }else {
            return new JsonBean(502,"登录失败",null);
        }
    }

    @Override
    public JsonBean updateUser(User user) {
        int num=userDao.updateByPrimaryKeySelective(user);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"更新成功",null);
        }else {
            return new JsonBean(500,"更新失败",null);
        }
    }

    @Override
    public JsonBean deleteUser(int[] ids) {
        return new JsonBean(200,"删除了"+userDao.deleteByPrimaryKey(ids)+"条数据",null);
    }

    @Override
    public JsonBean insertUser(User user) {
        int num = userDao.insertSelective(user);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"插入成功",null);
        }else {
            return new JsonBean(500,"插入失败",null);
        }
    }

    @Override
    public ResVO selectUser(UserDTO userDTO) {
        List<Object> users = userDao.selectUser(userDTO).get(0);
        long count = (long)userDao.selectUser(userDTO).get(1).get(0);
        return new ResVO(users,count);
    }

    @Override
    public List<String> selectCourse(int id) {
        return userDao.selectCourse(id);
    }
}
