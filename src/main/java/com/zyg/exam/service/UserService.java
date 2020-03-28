package com.zyg.exam.service;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResDTO;
import com.zyg.exam.common.UserDTO;
import com.zyg.exam.model.User;

import java.util.ArrayList;
import java.util.List;


public interface UserService {

    JsonBean isLogin(String number, String password);

    JsonBean updateUser(UserDTO userDTO);

    JsonBean deleteUser(ArrayList<Integer> ids);

    JsonBean insertUser(UserDTO userDTO);

    ResDTO selectUser(String name, String role);

    List<String> selectCourse(int id);



}
