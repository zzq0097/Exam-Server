package com.zyg.exam.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.exam.model.Class;
import com.zyg.exam.model.TeachInfo;
import com.zyg.exam.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassDao extends BaseMapper<Class>{
    int deleteByPrimaryKey(int[] classids);

    Class selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Class record);

    //根据班级id查询学生
    List<User> selectStudent(int classid);

    //查询班级授课信息
    List<TeachInfo> selectTeachInfo(int classid);

    List<Class> listClass();
}