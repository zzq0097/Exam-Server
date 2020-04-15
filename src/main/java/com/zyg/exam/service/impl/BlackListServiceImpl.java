package com.zyg.exam.service.impl;

import com.zyg.exam.dao.BlackListDao;
import com.zyg.exam.model.BlackList;
import com.zyg.exam.service.BlackListService;
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
public class BlackListServiceImpl extends ServiceImpl<BlackListDao, BlackList> implements BlackListService {
    @Autowired
    private BlackListDao blackListDao;

    @Override
    public List<String> getBlackListTypes() {
        return blackListDao.getBlackListTypes();
    }
}
