package com.zyg.exam.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckPaperDTO {
    private Integer classid;
    private Integer courseid;
    private String name;
    private Integer status;
    private Integer pageIndex;
    private Integer pageSize;
}
