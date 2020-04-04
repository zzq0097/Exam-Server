package com.zyg.exam.dao;

import com.zyg.exam.model.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChapterDao {
    int deleteByPrimaryKey(Integer chapterid);

    int insert(Chapter record);

    int insertSelective(Chapter chapter);

    Chapter selectByPrimaryKey(Integer chapterid);

    int updateByPrimaryKeySelective(Chapter chapter);

    int updateByPrimaryKey(Chapter record);

    List<Object> listChapter(int pageIndex,int pageSize);

    List<Object> selectQuestion(Integer chapterid);

    List<Chapter> getChapterName(int courseid);
}