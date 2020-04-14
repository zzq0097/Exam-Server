package com.zyg.exam.controller;

import com.zyg.exam.common.DTO.AddPaperDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.model.Strategy;
import com.zyg.exam.service.StrategyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class StrategyController {
    @Autowired
    private StrategyService strategyService;

    @RequestMapping("/insertStrategy")
    public JsonBean insertStrategy(Strategy strategy){
        return strategyService.insertStrategy(strategy);
    }

//    @RequestMapping(value = "/formPaper", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @RequestMapping(value = "/formPaper", method = RequestMethod.POST)
    public JsonBean formPaper(AddPaperDTO addPaperDTO){
        log.info("{}",addPaperDTO);
        return strategyService.formPaper(addPaperDTO);
    }
}
