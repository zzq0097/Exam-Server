package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseVO {
    private Integer courseid;
    private String coursename;
    private Integer teacherid;
    private String teachername;
}
