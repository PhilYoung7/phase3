package com.woniuxy.operate.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operate.dto.BookDto;
import com.woniuxy.operate.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-05
 */
public interface IBookService extends IService<Book> {

    Page find2Page(Page pageRequest, BookDto bookDto);

    Page find2Page2(Page<Book> pageRequest, BookDto bookDto);
}
