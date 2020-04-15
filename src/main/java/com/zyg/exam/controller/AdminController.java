package com.zyg.exam.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyg.exam.common.DTO.AdminDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Admin;
import com.zyg.exam.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-15
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/selectAdmin")
    public ResVO selectAdmin(AdminDTO adminDTO){
        Page<Admin> page = new Page<>(adminDTO.getPageIndex(),adminDTO.getPageSize());
        QueryWrapper<Admin> queryWrapper = null;
        if (StringUtils.isNotBlank(adminDTO.getName())){
            queryWrapper = new QueryWrapper<>();
            Map<String, String> map = new HashMap<>();
            map.put("name",adminDTO.getName());
            queryWrapper.allEq(map);
        }
        IPage<Admin> list = adminService.page(page,queryWrapper);
        return new ResVO(list.getRecords(),list.getTotal());
    }
    @RequestMapping("/updateAdmin")
    public JsonBean updateAdmin(Admin admin){
        return new JsonBean(200,"success",adminService.updateById(admin));
    }
    @RequestMapping("/insertAdmin")
    public JsonBean insertAdmin(Admin admin){
        return new JsonBean(200,"success",adminService.save(admin));
    }
    @RequestMapping("/deleteAdmin")
    public JsonBean deleteAdmin(List<Integer> ids){
        return new JsonBean(200,"success",adminService.removeByIds(ids));
    }
}

