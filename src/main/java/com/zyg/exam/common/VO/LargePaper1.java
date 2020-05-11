package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LargePaper1 {
    private String time;
    private Integer paperid;
    private Integer courseid;
    private String coursename;
}
