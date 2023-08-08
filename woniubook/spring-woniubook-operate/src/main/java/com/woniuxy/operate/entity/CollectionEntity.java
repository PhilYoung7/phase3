package com.woniuxy.operate.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
  @TableName("collection")
@ApiModel(value = "Collection对象", description = "")
public class CollectionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer bookId;

      private Integer collectionNumber;


}
