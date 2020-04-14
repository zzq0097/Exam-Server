package com.zyg.exam.model;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * record
 * @author 
 */
@Builder
@Data
@AllArgsConstructor
@NoAutoStart
public class Record implements Serializable {
    /**
     * 考试记录id
     */
    @TableId
    private Integer recordid;

    /**
     * 学生id
     */
    private Integer studentid;

    /**
     * 成绩
     */
    private String grade;

    /**
     * 监控
     */
    private String monitor;

    /**
     * 试卷id
     */
    private Integer paperid;

    private static final long serialVersionUID = 1L;


}