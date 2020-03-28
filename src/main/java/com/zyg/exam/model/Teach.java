package com.zyg.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * teach
 * @author 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teach implements Serializable {
    /**
     * 教师id
     */
    private Integer teacherid;

    /**
     * 课程id
     */
    private Integer courseid;

    /**
     * 任课老师id
     */
    private Integer teachid;

    /**
     * 授课时间
     */
    private String time;

    private static final long serialVersionUID = 1L;


}