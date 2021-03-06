package com.zyg.exam.service;

import com.zyg.exam.common.DTO.PagingQueryDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Class;

import java.util.List;

public interface ClassService {

    JsonBean selectStudentInClass(int classid);

    JsonBean selectTeachInfo(int classid);

    List<Class> listClass();

    JsonBean deleteClass(int[] ids);

    ResVO selectClass(PagingQueryDTO pagingQueryDTO);
}
