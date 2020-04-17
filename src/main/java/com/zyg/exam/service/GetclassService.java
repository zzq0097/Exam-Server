package com.zyg.exam.service;

import com.zyg.exam.common.DTO.GetClassDTO;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Getclass;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-17
 */
public interface GetclassService extends IService<Getclass> {
    ResVO selectGetClass(GetClassDTO getClassDTO);
}
