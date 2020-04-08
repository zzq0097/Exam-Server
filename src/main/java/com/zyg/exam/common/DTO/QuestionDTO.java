package com.zyg.exam.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private Integer courseid;
    private Integer chapterid;
    private String difficulty;
    private String key;
    private Integer pageIndex;
    private Integer pageSize;
}
