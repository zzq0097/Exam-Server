package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.TeachInfoDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
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
    public ResVO listTeachInfo(TeachInfoDTO teachInfoDTO) {
        List<Object> teachInfos = teachDao.listTeachInfo(teachInfoDTO).get(0);
        long count = (long)teachDao.listTeachInfo(teachInfoDTO).get(1).get(0);
        int total = (int)count;
        return new ResVO(teachInfos,total);

    }

    @Override
    public JsonBean deleteTeach(int[] teachids) {
        return new JsonBean(200,"删除了"+teachDao.deleteTeach(teachids)+"条数据",null);
    }

    @Override
    public JsonBean insertTeach(Teach teach) {
        int num = teachDao.insertSelective(teach);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"添加成功",null);
        }else {
            return new JsonBean(500,"删除失败",null);
        }
    }

    @Override
    public JsonBean updateTeach(Teach teach) {
        int num = teachDao.updateByPrimaryKeySelective(teach);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"修改成功",null);
        }else {
            return new JsonBean(500,"修改失败",null);
        }
    }
}
