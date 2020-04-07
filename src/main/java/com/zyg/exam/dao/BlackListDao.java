package com.zyg.exam.dao;

import com.zyg.exam.common.DTO.BlackListDTO;
import com.zyg.exam.model.BlackList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlackListDao {
    List<List<Object>> selectBlackList(BlackListDTO blackListDTO);
    int insert(BlackList blackList);
    int update(BlackList blackList);
    int delete(int[] ids);
    List<String> getBlackListTypes();
}
