package com.zyg.exam.service.impl;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.dao.TeachDao;
import com.zyg.exam.model.Teach;
import com.zyg.exam.model.TeachInfo;
import com.zyg.exam.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeachServiceImpl implements TeachService {
    @Autowired
    private TeachDao teachDao;

    @Override
    public JsonBean listTeachInfo() {
        List<TeachInfo> teachInfos = teachDao.listTeachInfo();
        if (teachInfos.size()>0){
            return new JsonBean(HttpStatus.OK.value(),teachInfos,"");
        }else {
            return new JsonBean(500,null,"所查结果为空");
        }
    }

    @Override
    public JsonBean deleteTeach(int teachId) {
        int num = teachDao.deleteTeach(teachId);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"删除成功");
        }else {
            return new JsonBean(500,null,"删除失败");
        }
    }

    @Override
    public JsonBean insertTeach(Teach teach) {
        int num = teachDao.insertSelective(teach);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"添加成功");
        }else {
            return new JsonBean(500,null,"删除失败");
        }
    }

    @Override
    public JsonBean updateTeach(Teach teach) {
        int num = teachDao.updateByPrimaryKeySelective(teach);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"修改成功");
        }else {
            return new JsonBean(500,null,"修改失败");
        }
    }
}
