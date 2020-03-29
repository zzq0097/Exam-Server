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

    int deleteByPrimaryKey(int[] ids);

    int insertSelective(User user);

    int updateByPrimaryKeySelective(User user);

    String login(String number);

    List<List<Object>> selectUser(Map<String,Object> params);

    List<String> selectCourse(int id);
}