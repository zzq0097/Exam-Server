package com.zyg.exam.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDTO {
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
    private String coursename;
    /**
     * 章节顺序
     */
    private String index;
    /**
     * 课程id
     */
    private int courseid;
}
