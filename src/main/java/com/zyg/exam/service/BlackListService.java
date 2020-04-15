package com.zyg.exam.service;

import com.zyg.exam.model.BlackList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-15
 */
public interface BlackListService extends IService<BlackList> {
    List<String> getBlackListTypes();
}
