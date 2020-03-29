package com.zyg.exam.dao;

import com.zyg.exam.common.UserDTO;
import com.zyg.exam.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDao {

    int deleteByPrimaryKey(Integer id);



    int insertSelective(User user);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User user);

    List<Object> selectByRole(String role);

    String login(String number);

    List<List<Object>> selectUser(Map<String,Object> params);

    List<Object> selectByName(String name);

    List<String> selectCourse(int id);
}