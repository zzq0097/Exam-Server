package com.zyg.exam.common.VO;

import lombok.Data;

@Data
public class BarVO {
    private int classid;
    private String classname;
    private int minScore;
    private double average;
    private int maxScore;
    private double variance;
}
