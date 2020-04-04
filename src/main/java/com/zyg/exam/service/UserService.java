package com.zyg.exam.service;

import com.zyg.exam.common.DTO.UserDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.User;

import java.util.List;

public interface UserService {

    JsonBean isLogin(String number, String password);

    JsonBean updateUser(User user);

    JsonBean deleteUser(int[] ids);

    JsonBean insertUser(User user);

    ResVO selectUser(UserDTO userDTO);

    List<String> selectCourse(int id);
}
