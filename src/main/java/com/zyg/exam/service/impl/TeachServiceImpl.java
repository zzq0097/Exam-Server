package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.TeachInfoDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.common.VO.OptionVO;
import com.zyg.exam.dao.TeachDao;
import com.zyg.exam.model.Teach;
import com.zyg.exam.model.TeachInfo;
import com.zyg.exam.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(rollbackFor =Exception.class)
@Service
public class TeachServiceImpl implements TeachService {
    @Autowired
    private TeachDao teachDao;

    @Override
    public ResVO listTeachInfo(TeachInfoDTO teachInfoDTO) {
        List<Object> teachInfos = teachDao.selectTeachInfo(teachInfoDTO).get(0);
        long total = (long)teachDao.selectTeachInfo(teachInfoDTO).get(1).get(0);
        return new ResVO(teachInfos,total);
    }

    @Override
    public JsonBean deleteTeach(int[] teachids) {
        int num=0;
        try {
            num=teachDao.deleteTeach(teachids);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new JsonBean(200,"删除了"+num+"条数据",null);
    }

    @Override
    public JsonBean insertTeach(Teach teach) {
        int num =0;
        try {
            num= teachDao.insertSelective(teach);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"添加成功",null);
        }else {
            return new JsonBean(500,"删除失败",null);
        }
    }

    @Override
    public JsonBean updateTeach(Teach teach) {
        int num =0;
        try {
            num=teachDao.updateByPrimaryKeySelective(teach);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"修改成功",null);
        }else {
            return new JsonBean(500,"修改失败",null);
        }
    }


}
