package com.zyg.exam.common.DTO;

import lombok.Data;

@Data
public class StudentDTO {
    private String name;
    private Integer classid;
    private Integer pageIndex;
    private Integer pageSize;
}
