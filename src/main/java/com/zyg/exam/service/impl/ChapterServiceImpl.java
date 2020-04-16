package com.zyg.exam.service.impl;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.dao.ChapterDao;
import com.zyg.exam.model.Chapter;
import com.zyg.exam.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(rollbackFor = Exception.class)
@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    @Override
    public JsonBean deleteChapter(int chapterId) {
        int num = chapterDao.deleteByPrimaryKey(chapterId);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"删除成功",null);
        }else {
            return new JsonBean(500,"删除失败",null);
        }
    }

    @Override
    public JsonBean updateChapter(Chapter chapter) {
        int num = chapterDao.updateByPrimaryKeySelective(chapter);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"修改成功",null);
        }else {
            return new JsonBean(500,"修改失败",null);
        }
    }

    @Override
    public JsonBean insertChapter(Chapter chapter) {
        int num = chapterDao.insertSelective(chapter);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"添加成功",null);
        }else {
            return new JsonBean(500,"添加失败",null);
        }
    }

    @Override
    public JsonBean selectQuestion(Integer chapterid) {
        List<Object> questions = chapterDao.selectQuestion(chapterid);
        if (questions.size()>0){
            return new JsonBean(HttpStatus.OK.value(),"",questions);
        }else {
            return new JsonBean(500,"查询结果为空",null);
        }
    }

    @Override
    public List<Chapter> getChapterName(Integer courseid) {
        return chapterDao.getChapterName(courseid);
    }
}
