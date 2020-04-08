package com.zyg.exam.service;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.model.Teach;
import org.springframework.stereotype.Service;


public interface TeachService {
    JsonBean listTeachInfo();

    JsonBean deleteTeach(int[] teachids);

    JsonBean insertTeach(Teach teach);

    JsonBean updateTeach(Teach teach);
}
