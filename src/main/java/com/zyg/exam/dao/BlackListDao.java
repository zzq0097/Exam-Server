package com.zyg.exam.dao;

import com.zyg.exam.model.BlackList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-15
 */
@Repository
public interface BlackListDao extends BaseMapper<BlackList> {
    List<String> getBlackListTypes();
}
