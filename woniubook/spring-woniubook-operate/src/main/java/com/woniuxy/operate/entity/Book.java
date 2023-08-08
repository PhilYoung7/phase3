package com.woniuxy.operate.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
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
  @TableName("book")
@ApiModel(value = "Book对象", description = "")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "book_id", type = IdType.AUTO)
      private Integer bookId;

    private String title;

    private String isbn;

    private String author;

    private String publisher;

    private Date publicationDate;

    private BigDecimal price;

    private String category;

    @TableLogic
    private Integer deleteFlag;

    @Version
    private Integer version;


}
