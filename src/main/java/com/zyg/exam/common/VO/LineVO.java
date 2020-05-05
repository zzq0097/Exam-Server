package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineVO {
    private String time;
    private int maxScore;
    private int avgScore;
    private int minScore;
}
