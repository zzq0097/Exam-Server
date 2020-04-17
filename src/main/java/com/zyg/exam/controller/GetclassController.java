package com.zyg.exam.controller;


import com.zyg.exam.common.DTO.GetClassDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Getclass;
import com.zyg.exam.service.GetclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("insertGetClass")
    public JsonBean insertGetClass(Getclass getclass){
        return new JsonBean(200,"success",getclassService.save(getclass));
    }
    @RequestMapping("updateGetClass")
    public JsonBean updateGetClass(Getclass getclass){
        return new JsonBean(200,"success",getclassService.updateById(getclass));
    }
    @RequestMapping("deleteGetClass")
    public JsonBean deleteGetClass(@RequestParam(value = "ids") List<Integer> ids){
        return new JsonBean(200,"success",getclassService.removeByIds(ids));
    }
}

