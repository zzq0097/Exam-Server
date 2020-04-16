package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.StudentDTO;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.UserDao;
import com.zyg.exam.model.User;
import com.zyg.exam.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public ResVO selectStudent(StudentDTO studentDTO) {
        List<Object> students = userDao.selectStudent(studentDTO).get(0);
        long total  = (long)userDao.selectStudent(studentDTO).get(1).get(0);
        return new ResVO(students,total);
    }
}
