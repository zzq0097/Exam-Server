package com.zyg.exam.common;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {
    private Integer recordId;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 成绩
     */
    private String grade;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 课程
     */
    private String courseName;
    /**
     * 班级
     */
    private String className;
}
