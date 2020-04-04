package com.zyg.exam.common;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResVO {
    List<Object>  list;
    long pageTotal;
}
