package com.zyg.exam.controller;

import com.zyg.exam.common.DTO.LineChartDTO;
import com.zyg.exam.common.VO.BarVO;
import com.zyg.exam.common.VO.EverQuestion;
import com.zyg.exam.common.VO.SpreadVO;
import com.zyg.exam.dao.PaperDao;
import com.zyg.exam.model.Class;
import com.zyg.exam.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChartsController {

    @Autowired
    private RecordService recordService;
    @Autowired
    private PaperDao paperDao;

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
    @RequestMapping("/getAllPaper")
    public List<?> getAllPaper(){
        return paperDao.selectList(null);
    }

    @RequestMapping("/selectAverage")
    public List<BarVO> selectAverage(Integer paperid){
        return recordService.selectAverage(paperid);
    }

    @RequestMapping("/selectSpread")
    public int[] selectSpread(Integer paperid, Integer classid){
        System.out.println("paperid"+paperid);
        System.out.println("classid"+classid);
        return recordService.selectSpread(paperid,classid);
    }

    @RequestMapping("/selectClassByPaperid")
    public List<Class> selectClass(Integer paperid){
        return recordService.selectClass(paperid);
    }

    @RequestMapping("/selectEverQues")
    public List<EverQuestion> selectEverQues(Integer paperid,Integer classid){
        return recordService.selectEverQues(paperid,classid);
    }

    @RequestMapping("/line_chart")
    public List<?> line_chart(LineChartDTO lineChartDTO){
        System.out.println(lineChartDTO);
        return recordService.selectTendency(lineChartDTO);
    }

}
