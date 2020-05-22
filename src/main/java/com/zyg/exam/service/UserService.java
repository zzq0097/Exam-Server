package com.zyg.exam.service;

import com.zyg.exam.common.DTO.StudentDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-15
 */
public interface UserService extends IService<User> {
    ResVO selectStudent(StudentDTO studentDTO);

    JsonBean batchImport(String fileName, MultipartFile file) throws Exception;

}
