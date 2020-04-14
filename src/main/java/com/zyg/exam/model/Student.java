package com.zyg.exam.model;

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
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 学生id
     */
      private Integer studentid;

    /**
     * 学号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 电话
     */
    private String tel;

    /**
     * 班级id
     */
    private String classid;


}
