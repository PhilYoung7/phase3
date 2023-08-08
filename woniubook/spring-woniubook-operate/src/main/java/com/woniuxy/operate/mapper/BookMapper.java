package com.woniuxy.operate.mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operate.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;
import com.woniuxy.operate.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-05
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    Page<Book> find2Page2(Page<Book> pageRequest,@Param("b") BookDto bookDto);
}
