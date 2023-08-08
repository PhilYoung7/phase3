package com.woniuxy.operate.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-05
 */
@Getter
@Setter
@ToString
  @TableName("reader")
@ApiModel(value = "Reader对象", description = "")
public class Reader implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "reader_id", type = IdType.AUTO)
      private Integer readerId;

    private String name;

    private String gender;

    private Integer age;

    private String idCard;

    private String phone;

    @TableLogic
    private Integer deleteFlag;

    @Version
    private Integer version;
}
