package com.zyg.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * answer
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer implements Serializable {
    /**
     * 考试记录id
     */
    private Integer recordid;

    /**
     * 试题id
     */
    private Integer questionid;

    /**
     * 答案
     */
    private String answer;

    /**
     * 得分
     */
    private String credit;


}