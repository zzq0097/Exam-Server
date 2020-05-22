package com.zyg.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyg.exam.common.DTO.ImportUser;
import com.zyg.exam.common.DTO.MultiUserDTO;
import com.zyg.exam.common.DTO.StudentDTO;
import com.zyg.exam.common.DTO.UserDTO;
import com.zyg.exam.common.VO.UserVO;
import com.zyg.exam.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseMapper<User> {





    int importUsers(ImportUser importUser);

    List<List<Object>> selectStudent(StudentDTO studentDTO);


}