package com.zyg.exam.controller;

import com.zyg.exam.common.DTO.TeachInfoDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Teach;
import com.zyg.exam.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeachController {
    @Autowired
    private TeachService teachService;

    @GetMapping("/selectTeachInfo")
    public ResVO listTeach(TeachInfoDTO teachInfoDTO){
        return teachService.listTeachInfo(teachInfoDTO);
    }

    @RequestMapping("/deleteTeachInfo")
    public JsonBean deleteTeach(int[] ids){
        return teachService.deleteTeach(ids);
    }

    @RequestMapping("/insertTeachInfo")
    public JsonBean insertTeach(Teach teach){
        return teachService.insertTeach(teach);
    }

    @RequestMapping("/updateTeachInfo")
    public JsonBean updateTeach(Teach teach){
        return teachService.updateTeach(teach);
    }

}
