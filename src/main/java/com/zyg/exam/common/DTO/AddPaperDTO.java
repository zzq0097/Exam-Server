package com.zyg.exam.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPaperDTO {
    private Integer mode;  // 组卷方式 1.全随机 2.按条件 3.手动
    private Integer courseid;
    private Integer pattern;
    private String ismonitor;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date starttime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishtime;

    private int[] questionids; // 手动组卷用

    private List<StrategyDTO> strategyDTOS; // 存储条件策略
}
