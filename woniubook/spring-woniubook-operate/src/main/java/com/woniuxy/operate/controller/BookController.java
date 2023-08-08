package com.woniuxy.operate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operate.dto.BookDto;
import com.woniuxy.operate.handler.Asserts;
import com.woniuxy.operate.handler.BusinessEnum;
import com.woniuxy.operate.handler.BusinessException;
import com.woniuxy.operate.pojos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operate.entity.Book;
import com.woniuxy.operate.service.IBookService;
import org.springframework.web.bind.annotation.RestController;

import static com.woniuxy.operate.handler.BusinessEnum.OPTIMISTIC_LOCK_ERROR;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-04
 */
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    private final IBookService bookServiceImpl;

    public BookController(IBookService bookServiceImpl){
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping("/add")
    public ResponseResult add(@RequestBody Book book){
        log.info("BookController-add()接收的参数：{}",book);
        bookServiceImpl.save(book);
        return ResponseResult.ok();
    }
    @PostMapping("/update")
    public ResponseResult update(@RequestBody Book book){
        log.info("BookController-update()接收的参数：{}",book);
        boolean b = bookServiceImpl.updateById(book);
        Asserts.fail(b == false, OPTIMISTIC_LOCK_ERROR);
        return ResponseResult.ok();
    }
    @PostMapping("/delete")
    public ResponseResult delete(@RequestBody Book book){
        log.info("BookController-delete()接收的参数：{}",book);
        bookServiceImpl.removeById(book);
        return ResponseResult.ok();
    }

    //log：运行日志 -> File，数据日志（登录日志，操作日志）-->DB
    // @GetMapping("/{id}")
    // public ResponseResult getById(@PathVariable("id") int id){
    //     log.info("BookController-getById()接收的参数：{}",id);
    //     Book book = bookServiceImpl.getById(id);
    //     return ResponseResult.ok(book);
    // }

    @GetMapping("/getById")
    public ResponseResult getById(int id){
       log.info("BookController-getById()接收的参数：{}",id);
       Book book = bookServiceImpl.getById(id);
       return ResponseResult.ok(book);
    }

    @GetMapping("/findAll")
    public ResponseResult findAll(){
        List<Book> list = bookServiceImpl.list();
        return ResponseResult.ok(list);
    }

    @GetMapping("/page")
    public ResponseResult find2Page(Integer pageSize,Integer pageNum, BookDto bookDto){
        Page<Object> pageRequest = Page.of(pageNum, pageSize);
        Page page = bookServiceImpl.find2Page(pageRequest,bookDto);
        return ResponseResult.ok(page);
    }

    @GetMapping("/page2")
    public ResponseResult find2Page2(Integer pageSize,Integer pageNum, BookDto bookDto){
        //封装分页请求对象
        Page<Book> pageRequest = Page.of(pageNum, pageSize);
        Page page = bookServiceImpl.find2Page2(pageRequest,bookDto);
        return ResponseResult.ok(page);
    }

}
