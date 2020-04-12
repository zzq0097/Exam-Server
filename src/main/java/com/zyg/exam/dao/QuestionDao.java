package com.zyg.exam.dao;

import com.zyg.exam.common.DTO.PaperQuestionDTO;
import com.zyg.exam.common.DTO.QuestionDTO;
import com.zyg.exam.common.VO.QuestionVO;
import com.zyg.exam.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionDao {
    int deleteByPrimaryKey(int[] subjectids);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer subjectid);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<List<Object>> selectQuestion(QuestionDTO questionDTO);

    List<List<Object>> listQuestion(QuestionDTO questionDTO);

    int insertQuestionDTO(QuestionVO questionVO);

    List<Integer> selectByType(String type);

    List<Integer> selectByChapter(String difficulty,Integer chapterid,String type);

    List<Object> selectByRecord(int recordid);

    List<Object> selectByPaperid(int paperid);


}