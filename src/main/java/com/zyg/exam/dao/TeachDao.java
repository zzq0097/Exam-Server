package com.zyg.exam.dao;

import com.zyg.exam.common.DTO.TeachInfoDTO;
import com.zyg.exam.common.VO.OptionVO;
import com.zyg.exam.model.Class;
import com.zyg.exam.model.Teach;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeachDao {
    int insert(Teach record);

    int insertSelective(Teach record);

    List<List<Object>> selectTeachInfo(TeachInfoDTO teachInfoDTO);

    int deleteTeach(int[] teachids);

    int updateByPrimaryKeySelective(Teach teach);

    List<OptionVO> selectTeacher(Integer courseid);

    List<OptionVO> optionTeachInfo();

    List<Class> selectClass(Integer teachid);
}