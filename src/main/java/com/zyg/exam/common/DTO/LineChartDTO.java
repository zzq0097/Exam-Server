package com.zyg.exam.common.DTO;

import lombok.Data;

@Data
public class LineChartDTO {
    private Integer courseid;
    private Integer classid;
    private String[] line_time;
}
