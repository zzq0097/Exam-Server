package com.zyg.exam.service;

import com.zyg.exam.common.DTO.TeachInfoDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.common.VO.OptionVO;
import com.zyg.exam.model.Teach;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeachService {
    ResVO listTeachInfo(TeachInfoDTO teachInfoDTO);

    JsonBean deleteTeach(int[] teachids);

    JsonBean insertTeach(Teach teach);

    JsonBean updateTeach(Teach teach);


}
