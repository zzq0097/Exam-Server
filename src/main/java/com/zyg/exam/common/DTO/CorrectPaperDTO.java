package com.zyg.exam.common.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorrectPaperDTO {
    private Integer recordid;

    List<CreditDTO> creditDTOS;
}
