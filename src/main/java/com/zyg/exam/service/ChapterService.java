package com.zyg.exam.service;

import com.zyg.exam.common.ChapterDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.model.Chapter;

import java.util.List;

public interface ChapterService {



    JsonBean deleteChapter(int chapterId);

    JsonBean updateChapter(Chapter chapter);

    JsonBean insertChapter(Chapter chapter);

    JsonBean selectQuestion(Integer chapterid);

    List<Chapter> getChapterName(Integer courseid);
}
