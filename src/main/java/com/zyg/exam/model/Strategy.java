package com.zyg.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * strategy
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Strategy  {
    /**
     * 策略id
     */
    private Integer strategyid;

    /**
     * 试题类型
     */
    private String type;

    /**
     * 分值
     */
    private int value;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 试卷id
     */
    private Integer paperid;

    private static final long serialVersionUID = 1L;


}