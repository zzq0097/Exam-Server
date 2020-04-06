package com.zyg.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * condition
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condition {
    /**
     * 难度
     */
    private String difficulty;

    /**
     * 章节id
     */
    private Integer chapterid;

    /**
     * 策略id
     */
    private Integer strategyid;

    private Integer count;

    private static final long serialVersionUID = 1L;


}