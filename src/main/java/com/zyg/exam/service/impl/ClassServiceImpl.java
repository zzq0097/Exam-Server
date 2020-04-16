package com.zyg.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.exam.common.DTO.PagingQueryDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.ClassDao;
import com.zyg.exam.model.Class;
import com.zyg.exam.model.TeachInfo;
import com.zyg.exam.model.User;
import com.zyg.exam.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(rollbackFor = Exception.class)
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

    @Override
    public ResVO selectClass(PagingQueryDTO pagingQueryDTO){
        Page<Class> page = new Page<>(pagingQueryDTO.getPageIndex(),pagingQueryDTO.getPageSize());
        IPage<Class> classList = classDao.selectPage(page,null);
        return new ResVO(classList.getRecords(),classList.getTotal());
    }

    @Override
    public JsonBean deleteClass(int[] ids) {
        int num=0;
        try {
            num=classDao.deleteByPrimaryKey(ids);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new JsonBean(200,"删除了"+num+"条数据",null);
    }
}
