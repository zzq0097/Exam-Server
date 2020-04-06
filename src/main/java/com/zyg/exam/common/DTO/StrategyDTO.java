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
    private Integer chapterid;
    private String difficulty;
}
