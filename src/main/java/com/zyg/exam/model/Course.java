package com.zyg.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * course
 * @author 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    /**
     * 课程id
     */
    private Integer courseid;

    /**
     * 课程名称
     */
    private String coursename;

    /**
     * 课程负责人
     */
    private String programleader;


}