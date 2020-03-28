package com.zyg.exam.model;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * chapter
 * @author 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chapter implements Serializable {
    /**
     * 章节id
     */
    private Integer chapterid;

    /**
     * 章节名称
     */
    private String chaptername;

    /**
     * 课程id
     */
    private Integer courseid;
    /**
     * 章节顺序
     */
    private String index;

    private static final long serialVersionUID = 1L;


}