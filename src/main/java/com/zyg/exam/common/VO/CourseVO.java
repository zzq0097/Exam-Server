package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseVO {
    private Integer courseid;

    /**
     * 课程名称
     */
    private String coursename;

    /**
     * 课程负责人
     */
    private String name;
}
