package com.zyg.exam.service.impl;

import com.zyg.exam.model.Student;
import com.zyg.exam.dao.StudentMapper;
import com.zyg.exam.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-14
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
