package com.zyg.exam.common.VO;

import com.zyg.exam.model.Class;
import lombok.Data;

import java.util.List;

@Data
public class TeachInfoVO {
    private int id;
    private int teacherid;
    private String teachername;
    private int courseid;
    private String coursename;

    private List<Class> classes;
}
