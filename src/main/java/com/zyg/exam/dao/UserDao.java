package com.zyg.exam.dao;

import com.zyg.exam.common.UserDTO;
import com.zyg.exam.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface UserDao {

    int deleteByPrimaryKey(Integer id);



    int insertSelective(UserDTO userDTO);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserDTO userDTO);

    List<Object> selectByRole(String role);

    String login(String number);

    List<Object> selectUser();

    List<Object> selectByName(String name);

    List<String> selectCourse(int id);
}