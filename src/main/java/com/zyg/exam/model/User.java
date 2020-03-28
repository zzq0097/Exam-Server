package com.zyg.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 教师id
     */
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
    private Integer classname;



    private Date insert_date;

    private static final long serialVersionUID = 1L;


}