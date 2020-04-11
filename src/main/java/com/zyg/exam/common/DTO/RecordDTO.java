package com.zyg.exam.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDTO {
    private Integer classid;
    private Integer courseid;
    private String name;
    private Integer pageIndex;
    private Integer pageSize;
}
