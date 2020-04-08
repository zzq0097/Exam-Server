package com.zyg.exam.controller;


import com.zyg.exam.common.DTO.QuestionDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Question;
import com.zyg.exam.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/insertQuestion")
    public JsonBean insertQuestion(Question question){
        return questionService.insertQuestion(question);
    }

    @PostMapping("/deleteQuestion")
    public JsonBean deleteQuestion(int[] ids){
        return questionService.deleteQuestion(ids);
    }

    @GetMapping("/selectQuestion")
    public ResVO selectByDifficulty(QuestionDTO questionDTO){
        return questionService.selectQuestion(questionDTO);
    }

    @PostMapping("/updateQuestion")
    public JsonBean updateQuestion(Question question){
        return questionService.updateQuestion(question);
    }

    @PostMapping("/importQuestion")
    public JsonBean addQuestion(@RequestParam("file") MultipartFile file){
        JsonBean jsonBean=new JsonBean();
        String fileName = file.getOriginalFilename();
        log.info("{}",fileName);
        try {
            jsonBean=questionService.batchImport(fileName,file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  jsonBean;
    }
}
