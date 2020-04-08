package com.zyg.exam.dao;

import com.zyg.exam.model.Teach;
import com.zyg.exam.model.TeachInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeachDao {
    int insert(Teach record);

    int insertSelective(Teach record);

    List<TeachInfo> listTeachInfo();

    int deleteTeach(int[] teachids);

    int updateByPrimaryKeySelective(Teach teach);
}