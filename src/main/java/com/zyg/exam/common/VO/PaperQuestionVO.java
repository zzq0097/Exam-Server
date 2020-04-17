package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// 返回一个集合
public class PaperQuestionVO {
    private String type;
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int score;
    private int stuScore;
    private String answer;
    private String stuAnswer;
    private Integer questionid;
    private Integer answerid;
}
