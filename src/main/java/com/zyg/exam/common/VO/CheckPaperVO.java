package com.zyg.exam.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckPaperVO {
    private int recordid;
    private int studentid;
    private String studentname;
    private int classid;
    private String classname;
    private int courseid;
    private String coursename;
    private int status;
    private String time;
}
