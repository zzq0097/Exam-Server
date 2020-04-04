package com.zyg.exam.service.impl;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.dao.ClassDao;
import com.zyg.exam.model.Class;
import com.zyg.exam.model.TeachInfo;
import com.zyg.exam.model.User;
import com.zyg.exam.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public JsonBean selectStudentInClass(int classid) {
        List<User> users = classDao.selectStudent(classid);
        if (users.size()>0){
            return new JsonBean(HttpStatus.OK.value(),"",users);
        }else {
            return new JsonBean(500,"所查结果为空",null);
        }
    }

    @Override
    public JsonBean selectTeachInfo(int classid) {
        List<TeachInfo> teachInfos = classDao.selectTeachInfo(classid);
        if (teachInfos.size()>0){
            return new JsonBean(HttpStatus.OK.value(),"",teachInfos);
        }else {
            return new JsonBean(500,"所查结果为空",null);
        }
    }

    @Override
    public List<Class> listClass() {
        return classDao.listClass();
    }
}
