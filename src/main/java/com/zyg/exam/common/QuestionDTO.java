package com.zyg.exam.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    /**
     * 试题id
     */
    private Integer subjectid;

    /**
     * 试题类型
     */
    private String type;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 选项1
     */
    private String option1;

    /**
     * 选项2
     */
    private String option2;

    /**
     * 选项3
     */
    private String option3;

    /**
     * 选项4
     */
    private String option4;

    /**
     * 答案
     */
    private String answer;

    /**
     * 难度
     */
    private String difficulty;

    /**
     * 章节
     */
    private String chaptername;

    /**
     * 课程
     */
    private String coursename;
}
