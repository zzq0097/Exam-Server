package com.zyg.exam.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetClassDTO {
    private Integer classid;
    private Integer pageIndex;
    private Integer pageSize;
}
