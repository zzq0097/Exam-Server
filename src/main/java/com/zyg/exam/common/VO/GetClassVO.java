package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetClassVO {
    private int getclassid;
    private int classid;
    private String classname;
    private int teachid;
    private String teachInfo;   // 谁谁谁 - Java
}
