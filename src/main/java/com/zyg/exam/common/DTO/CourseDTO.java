package com.zyg.exam.common.DTO;

import lombok.Data;

@Data
public class CourseDTO {
    private String coursename;
    private Integer pageIndex;
    private Integer pageSize;
}
