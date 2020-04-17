package com.zyg.exam.controller;


import com.zyg.exam.common.DTO.GetClassDTO;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.service.GetclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-17
 */
@RestController
public class GetclassController {
@Autowired
    private GetclassService getclassService;


    @RequestMapping("/selectGetClass")
    public ResVO selectGetClass(GetClassDTO getClassDTO){
        return getclassService.selectGetClass(getClassDTO);
    }
}

