package com.zyg.exam.dao;

import com.zyg.exam.common.DTO.GetClassDTO;
import com.zyg.exam.model.Getclass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-17
 */
@Mapper
@Repository
public interface GetclassDao extends BaseMapper<Getclass> {

    List<List<Object>> selectGetClass(GetClassDTO getClassDTO);

}
