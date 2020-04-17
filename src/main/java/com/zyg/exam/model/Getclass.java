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
 * @since 2020-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Getclass implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "getclassid", type = IdType.AUTO)
    private Integer getclassid;

    /**
     * 任课老师id
     */
    private Integer teachid;

    /**
     * 班级id
     */
    private Integer classid;


}
