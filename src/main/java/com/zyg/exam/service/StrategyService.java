package com.zyg.exam.service;

import com.zyg.exam.common.DTO.AddPaperDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.model.Strategy;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

public interface StrategyService {

    JsonBean insertStrategy(Strategy strategy);

    JsonBean formPaper(AddPaperDTO addPaperDTO);


}
