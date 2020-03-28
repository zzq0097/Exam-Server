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
import java.util.List;

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
    public JsonBean updateUser(UserDTO userDTO) {
        int num=userDao.updateByPrimaryKeySelective(userDTO);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"更新成功");
        }else {
            return new JsonBean(500,null,"更新失败");
        }
    }

    @Override
    public JsonBean deleteUser(ArrayList<Integer> ids) {
        int num=0;
       for (int i=0;i<ids.size();i++){
            num = userDao.deleteByPrimaryKey(ids.size())+1;
       }
        if (num>ids.size()){
            return new JsonBean(HttpStatus.OK.value(),null,"删除成功");
        }else {
            return new JsonBean(500,null,"删除失败");
        }
    }

    @Override
    public JsonBean insertUser(UserDTO userDTO) {
        int num = userDao.insertSelective(userDTO);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"插入成功");
        }else {
            return new JsonBean(500,null,"插入失败");
        }
    }

    @Override
    public ResDTO selectUser(String name, String role) {
        List<Object> users = new ArrayList<>();

        if(name==null&&role==null){
            users = userDao.selectUser();
        }else if (!role.isEmpty()&&role!=null){
            users = userDao.selectByRole(role);
        }else if (!name.isEmpty()&&name!=null){
            users = userDao.selectByName(name);
        }
        return new ResDTO(users,users.size());
    }

    @Override
    public List<String> selectCourse(int id) {
        return userDao.selectCourse(id);
    }


}
