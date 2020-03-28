package com.zyg.exam.service.impl;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResDTO;
import com.zyg.exam.dao.ChapterDao;
import com.zyg.exam.dao.CourseDao;
import com.zyg.exam.dao.QuestionDao;
import com.zyg.exam.model.Question;
import com.zyg.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private CourseDao courseDao;

    @Override
    public JsonBean insertQuestion(Question question) {
        int num = questionDao.insertSelective(question);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"添加成功");
        }else {
            return new JsonBean(500,null,"添加失败");
        }
    }

    @Override
    public JsonBean deleteQuestion(int subjectId) {
        int num = questionDao.deleteByPrimaryKey(subjectId);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"删除成功");
        }else {
            return new JsonBean(500,null,"删除失败");
        }
    }

    @Override
    public JsonBean updateQuestion(Question question) {
        int num = questionDao.updateByPrimaryKeySelective(question);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),null,"修改成功");
        }else {
            return new JsonBean(500,null,"修改失败");
        }
    }



    @Override
    public ResDTO selectQuestion(String difficulty, Integer chapterid, Integer courseid, String key) {
        List<Object> questions = new ArrayList<>();


         if(!difficulty.isEmpty()&&difficulty!=null){
             System.out.println("只执行难度");
            questions = questionDao.selectByDifficulty(difficulty);
        }else if(chapterid!=null){
             System.out.println("执行chapterid");
            questions = chapterDao.selectQuestion(chapterid);
        }else if(courseid!=null){
             System.out.println("只执行courseid");
            questions = courseDao.selectQuestion(courseid);
        }else if(!key.isEmpty()&&key!=null){
            questions = questionDao.selectByContent(key);
        }else if(difficulty!=null&&chapterid!=null&&!difficulty.isEmpty()){
            questions = questionDao.selectByCHapterAndDifficulty(difficulty,chapterid);
         }else if(difficulty!=null&&courseid!=null&&!difficulty.isEmpty()){
             questions = questionDao.selectByCourseAndDifficulty(difficulty,courseid);
         }
         else {
            questions = questionDao.listQuestion();
        }
        return new ResDTO(questions,questions.size());
    }


}
