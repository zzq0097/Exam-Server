package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.GetClassDTO;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Getclass;
import com.zyg.exam.dao.GetclassDao;
import com.zyg.exam.service.GetclassService;
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
 * @since 2020-04-17
 */
@Service
public class GetclassServiceImpl extends ServiceImpl<GetclassDao, Getclass> implements GetclassService {
@Autowired
private GetclassDao getclassDao;
    @Override
    public ResVO selectGetClass(GetClassDTO getClassDTO) {
        List<Object> getClass = getclassDao.selectGetClass(getClassDTO).get(0);
        long count=(long)getclassDao.selectGetClass(getClassDTO).get(1).get(0);
        return new ResVO(getClass,count);
    }
}
