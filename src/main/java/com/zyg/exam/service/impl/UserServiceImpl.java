package com.zyg.exam.service.impl;

import com.zyg.exam.model.User;
import com.zyg.exam.dao.UserMapper;
import com.zyg.exam.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
