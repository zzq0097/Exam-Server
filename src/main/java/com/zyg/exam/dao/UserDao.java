package com.zyg.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyg.exam.common.DTO.MultiUserDTO;
import com.zyg.exam.common.DTO.UserDTO;
import com.zyg.exam.common.VO.UserVO;
import com.zyg.exam.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseMapper<User> {

    int deleteByPrimaryKey(int[] ids);

    int insertSelective(User user);

    int updateByPrimaryKeySelective(User user);

    List<User> login(String username, String password);

    List<List<Object>> selectUser(UserDTO userDTO);

    List<String> selectCourse(int id);

    int importUser(UserVO userVO);
}