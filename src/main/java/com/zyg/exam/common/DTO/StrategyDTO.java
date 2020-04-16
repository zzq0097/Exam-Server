package com.zyg.exam.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StrategyDTO {
    private String type;
    private Integer count;
    private Integer score;
    private Integer mode;  // 组卷方式 1.全随机 2.按条件 3.手动
    private Integer chapterid;
    private String difficulty;
    private int[] questionids; // 手动组卷用
}
