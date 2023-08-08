package com.woniuxy.operate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operate.dto.BookDto;
import com.woniuxy.operate.entity.Book;
import com.woniuxy.operate.mapper.BookMapper;
import com.woniuxy.operate.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-05
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    private final BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper){
        this.bookMapper = bookMapper;
    }

    @Override
    public Page find2Page(Page pageRequest, BookDto bookDto) {
        //创建一个条件查询器
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.likeRight(StringUtils.hasLength(bookDto.getAuthor()),Book::getAuthor,bookDto.getAuthor());
        lqw.likeRight(StringUtils.hasLength(bookDto.getTitle()),Book::getTitle,bookDto.getTitle());
        //根据ID进行降序查询
        lqw.orderByAsc(Book::getBookId);

        Page page = bookMapper.selectPage(pageRequest, lqw);
        return page;
    }

    @Override
    public Page find2Page2(Page<Book> pageRequest, BookDto bookDto) {
        Page<Book> page =  bookMapper.find2Page2(pageRequest,bookDto);
        return page;
    }
}
