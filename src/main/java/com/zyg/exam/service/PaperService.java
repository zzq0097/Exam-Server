package com.zyg.exam.service;

import com.zyg.exam.common.DTO.PaperDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Paper;

public interface PaperService {
    ResVO selectPaper(PaperDTO paperDTO);

    JsonBean deletePaper(int[] paperids);

    ResVO selectQuestion(Integer paperId, Integer pageIndex, Integer pageSize);

    JsonBean updatePaper(Paper paper);


}
