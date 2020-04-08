package com.zyg.exam.dao;

import com.zyg.exam.model.Class;
import com.zyg.exam.model.TeachInfo;
import com.zyg.exam.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassDao {
    int deleteByPrimaryKey(int[] classids);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Class record);

    //根据班级id查询学生
    List<User> selectStudent(int classid);

    //查询班级授课信息
    List<TeachInfo> selectTeachInfo(int classid);

    List<Class> listClass();
}