package com.zyg.exam.controller;


import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResDTO;
import com.zyg.exam.model.Question;
import com.zyg.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PutMapping("/insertQuestion")
    public JsonBean insertQuestion(Question question){
        return questionService.insertQuestion(question);
    }

    @DeleteMapping("/deleteQuestion")
    public JsonBean deleteQuestion(int subjectId){
        return questionService.deleteQuestion(subjectId);
    }



    @GetMapping("/selectQuestion")
    public ResDTO selectByDifficulty(String difficulty, Integer chapterid, Integer courseid, String key){
        return questionService.selectQuestion(difficulty,chapterid,courseid,key);
    }
}
