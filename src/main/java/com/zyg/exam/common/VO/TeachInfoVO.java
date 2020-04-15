package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeachInfoVO {
    private int id;
    private int teacherid;
    private String teachername;
    private int classid;
    private String classname;
}
