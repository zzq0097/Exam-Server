package com.zyg.exam.common.VO;

import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private Integer id;

    /**
     * 教师名称
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String tel;

    /**
     * 工号
     */
    private String username;

    /**
     * 角色
     */
    private String role;

    /**
     * 学生所属班级
     */
    private String classname;



    private Date insert_date;
}
