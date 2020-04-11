package com.zyg.exam.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * class
 * @author 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Class implements Serializable {
    /**
     * 班级id
     */
    @TableId(type = IdType.AUTO)
    private Integer classid;

    /**
     * 班级名称
     */
    private String classname;

    private static final long serialVersionUID = 1L;


}