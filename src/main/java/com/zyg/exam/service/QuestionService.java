package com.zyg.exam.service;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResDTO;
import com.zyg.exam.model.Question;
import org.springframework.web.multipart.MultipartFile;

public interface QuestionService {

    JsonBean insertQuestion(Question question);

    JsonBean deleteQuestion(int subjectId);

    JsonBean updateQuestion(Question question);



    ResDTO selectQuestion(String difficulty, Integer chapterid, Integer courseid, String key );

    JsonBean batchImport(String fileName, MultipartFile file) throws Exception;

}
