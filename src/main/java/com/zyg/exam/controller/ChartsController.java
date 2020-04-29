package com.zyg.exam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChartsController {

    // 柱状图
    @RequestMapping("/barChart")
    public List<?> barChart(Integer id){

        return null;
    }
    // 饼状图
    @RequestMapping("/pieChart")
    public List<?> pieChart(Integer id){

        return null;
    }
    // 折线图
    @RequestMapping("/lineChart")
    public List<?> lineChart(Integer id){

        return null;
    }

}
