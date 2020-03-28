package com.zyg.exam.controller;

import com.zyg.exam.common.ChapterDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.model.Chapter;
import com.zyg.exam.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChapterController {
    @Autowired
    private ChapterService chapterService;



    @DeleteMapping("/deleteChapter")
    public JsonBean deleteChapter(int chapterId){
        return chapterService.deleteChapter(chapterId);
    }

    @PostMapping("/updateChapter")
    public JsonBean updateChapter(Chapter chapter){
        return chapterService.updateChapter(chapter);
    }

    @PostMapping("/insertChapter")
    public JsonBean insertChapter(Chapter chapter){
        return chapterService.insertChapter(chapter);
    }


}
