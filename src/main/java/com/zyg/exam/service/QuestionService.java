package com.zyg.exam.service;

import com.zyg.exam.common.DTO.QuestionDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Question;
import org.springframework.web.multipart.MultipartFile;

public interface QuestionService {

    JsonBean insertQuestion(Question question);

    JsonBean deleteQuestion(int[] subjectids);

    JsonBean updateQuestion(Question question);

    ResVO selectQuestion(QuestionDTO questionDTO);

    JsonBean batchImport(String fileName, MultipartFile file) throws Exception;

}
