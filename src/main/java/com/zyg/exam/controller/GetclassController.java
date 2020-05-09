package com.zyg.exam.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyg.exam.common.DTO.GetClassDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Getclass;
import com.zyg.exam.service.GetclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(getclass);
        QueryWrapper<Getclass> queryWrapper = new QueryWrapper<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("teachid",getclass.getTeachid());
        map.put("classid",getclass.getClassid());
        queryWrapper.allEq(map);
        if (getclassService.list(queryWrapper).size()>0){
            return new JsonBean(500,"error:班级已存在",null);
        }
        return new JsonBean(200,"success",getclassService.save(getclass));
    }
    @RequestMapping("updateGetClass")
    public JsonBean updateGetClass(Integer teachid, int[] classes){
        QueryWrapper<Getclass> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teachid",teachid);
        getclassService.remove(queryWrapper);
        for (Integer classid: classes) {
            getclassService.save(new Getclass(teachid,classid));
        }
        return new JsonBean(200,"success",null);
    }
    @RequestMapping("deleteGetClass")
    public JsonBean deleteGetClass(@RequestParam(value = "ids") List<Integer> ids){
        return new JsonBean(200,"success",getclassService.removeByIds(ids));
    }
}

