package com.zyg.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeachInfo {
    /**
     * 授课老师id
     */
    private int teachid;

    /**
     * 教师名称
     */
    private String name;

    /**
     * 课程名称
     */
    private String coursename;

    /**
     * 班级
     */
    private String classname;

    /**
     * 授课时间
     */
    private String time;
}
