package com.zyg.exam.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeachInfoDTO {
    private Integer courseid;
    private Integer classid;
    private String name;
    private Integer pageIndex;
    private Integer pageSize;
}
