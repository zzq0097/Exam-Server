package com.zyg.exam.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 教师id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 工号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 教师名称
     */
    private String name;

    /**
     * 电话
     */
    private String tel;

    /**
     * 角色
     */
    private String role;

    /**
     * 班级id
     */
    private Integer classid;


}
