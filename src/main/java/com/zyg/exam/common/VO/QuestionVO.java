package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionVO {

    private Integer subjectid;

    private String type;

    private String content;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String answer;

    private String difficulty;

    private String chapterName;

    private String courseName;


}
