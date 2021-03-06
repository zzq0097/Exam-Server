package com.zyg.exam.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZZQ
 * @since 2020-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teacher implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 老师id
     */
    @TableId(type = IdType.AUTO)
    private Integer teacherid;

    /**
     * 工号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 老师姓名
     */
    private String name;

    /**
     * 电话
     */
    private String tel;


}
