package com.zyg.exam.common.DTO;

import lombok.Data;

@Data
public class GetClassDTO {
    private Integer classid;
    private Integer pageIndex;
    private Integer pageSize;
}
