package com.woniuxy.operate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
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
  @TableName("borrow")
@ApiModel(value = "Borrow对象", description = "")
public class Borrow implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "borrow_id", type = IdType.AUTO)
      private Integer borrowId;

    private Integer bookId;

    private Integer readerId;

    private Date borrowDate;

    private Date returnDate;

    private Date actualReturnDate;


}
