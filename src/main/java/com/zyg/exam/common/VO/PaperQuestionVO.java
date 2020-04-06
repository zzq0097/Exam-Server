package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// 返回一个集合
public class PaperQuestionVO {
    private int type;
    private String title;
    private String options;
    private int score;
    private int stuScore;
    private String answer;
    private String stuAnswer;
}
