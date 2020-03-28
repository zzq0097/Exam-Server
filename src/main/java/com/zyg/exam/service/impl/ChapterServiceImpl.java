package com.zyg.exam.service.impl;

import com.zyg.exam.common.ChapterDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.dao.ChapterDao;
import com.zyg.exam.model.Chapter;
import com.zyg.exam.model.Question;
import com.zyg.exam.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;




    @Override
    public JsonBean deleteChapter(int chapterId) {
        int num = chapterDao.deleteByPrimaryKey(chapterId);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"删除成功");
        }else {
            return new JsonBean(500,null,"删除失败");
        }
    }

    @Override
    public JsonBean updateChapter(Chapter chapter) {
        int num = chapterDao.updateByPrimaryKeySelective(chapter);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"修改成功");
        }else {
            return new JsonBean(500,null,"修改失败");
        }
    }

    @Override
    public JsonBean insertChapter(Chapter chapter) {
        int num = chapterDao.insertSelective(chapter);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"添加成功");
        }else {
            return new JsonBean(500,null,"添加失败");
        }
    }

    @Override
    public JsonBean selectQuestion(Integer chapterid) {
        List<Object> questions = chapterDao.selectQuestion(chapterid);
        if (questions.size()>0){
            return new JsonBean(HttpStatus.OK.value(),questions,"");
        }else {
            return new JsonBean(500,null,"查询结果为空");
        }
    }

    @Override
    public List<Chapter> getChapterName(Integer courseid) {
        return chapterDao.getChapterName(courseid);
    }
}
