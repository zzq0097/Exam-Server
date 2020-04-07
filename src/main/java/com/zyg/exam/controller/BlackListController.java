package com.zyg.exam.controller;

import com.zyg.exam.common.DTO.BlackListDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.BlackListDao;
import com.zyg.exam.model.BlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlackListController {

    @Autowired
    private BlackListDao blackListDao;

    @RequestMapping("selectBlackList")
    public ResVO selectBlackList(BlackListDTO blackListDTO){
        List<Object> blackLists = blackListDao.selectBlackList(blackListDTO).get(0);
        long count = (long)blackListDao.selectBlackList(blackListDTO).get(1).get(0);
        return new ResVO(blackLists,count);
    }
    @RequestMapping("insertBlackList")
    public JsonBean insertBlackList(BlackList blackList){
        if (blackListDao.insert(blackList) > 0) {
            return new JsonBean(200,"success",null);
        }
        return new JsonBean(502,"插入失败",null);
    }
    @RequestMapping("updateBlackList")
    public JsonBean updateBlackList(BlackList blackList){
        if (blackListDao.update(blackList) > 0) {
            return new JsonBean(200,"success",null);
        }
        return new JsonBean(502,"更新失败",null);
    }
    @RequestMapping("deleteBlackList")
    public JsonBean deleteBlackList(int[] ids){
        if (blackListDao.delete(ids) > 0) {
            return new JsonBean(200,"success",null);
        }
        return new JsonBean(502,"删除失败",null);
    }
    @RequestMapping("getBlackListTypes")
    public List<String> getBlackListTypes(){
        return blackListDao.getBlackListTypes();
    }
}
