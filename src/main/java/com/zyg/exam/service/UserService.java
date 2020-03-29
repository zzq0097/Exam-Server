package com.zyg.exam.service;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResDTO;
import com.zyg.exam.model.User;

import java.util.List;

public interface UserService {

    JsonBean isLogin(String number, String password);

    JsonBean updateUser(User user);

    JsonBean deleteUser(int[] ids);

    JsonBean insertUser(User user);

    ResDTO selectUser(String name, String role, Integer pageIndex, Integer pageSie);

    List<String> selectCourse(int id);
}
