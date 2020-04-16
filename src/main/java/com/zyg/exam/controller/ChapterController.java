package com.zyg.exam.controller;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.dao.ChapterDao;
import com.zyg.exam.model.Chapter;
import com.zyg.exam.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private ChapterDao chapterDao;
    @RequestMapping("/deleteChapter")
    public JsonBean deleteChapter(@RequestParam("ids")List<Integer> ids){
        return new JsonBean(200,"success",chapterDao.deleteBatchIds(ids));
    }

    @RequestMapping("/updateChapter")
    public JsonBean updateChapter(Chapter chapter){
        return chapterService.updateChapter(chapter);
    }

    @RequestMapping("/insertChapter")
    public JsonBean insertChapter(Chapter chapter){
        return chapterService.insertChapter(chapter);
    }

    @RequestMapping("/getChapterList")
    public List<Chapter> getChapterName(Integer courseid){
        System.out.println("courseid  "+courseid);
        return chapterService.getChapterName(courseid);
    }
}
