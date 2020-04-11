package com.zyg.exam.common.DTO;

import lombok.Data;

@Data
public class PagingQueryDTO {
    private Integer pageIndex;
    private Integer pageSize;
}
