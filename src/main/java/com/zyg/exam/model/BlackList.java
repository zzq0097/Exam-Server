package com.zyg.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlackList {
    private int id;
    private String name;
    private String type;
    private String process;
}
