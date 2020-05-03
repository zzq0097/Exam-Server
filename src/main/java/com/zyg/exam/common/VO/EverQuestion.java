package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EverQuestion {
    private Integer questionid;
    private String content;
    private Integer maxnum;
    private Integer minnum;
    private Integer avgnum;
    private float percent;
}
