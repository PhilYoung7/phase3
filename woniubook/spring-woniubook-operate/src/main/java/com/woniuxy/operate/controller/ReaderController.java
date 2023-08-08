package com.woniuxy.operate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operate.dto.AdminDto;
import com.woniuxy.operate.dto.ReaderDto;
import com.woniuxy.operate.entity.Admin;
import com.woniuxy.operate.handler.Asserts;
import com.woniuxy.operate.pojos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operate.entity.Reader;
import com.woniuxy.operate.service.IReaderService;
import org.springframework.web.bind.annotation.RestController;

import static com.woniuxy.operate.handler.BusinessEnum.OPTIMISTIC_LOCK_ERROR;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-05
 */
@Slf4j
@RestController
@RequestMapping("/reader")
public class ReaderController {

    private final IReaderService readerServiceImpl;

    public ReaderController(IReaderService readerServiceImpl){
        this.readerServiceImpl = readerServiceImpl;
    }

    @PostMapping("/add")
    public ResponseResult add(@RequestBody Reader reader){
        log.info("AdminController-add()接收的参数：{}",reader);
        readerServiceImpl.save(reader);
        return ResponseResult.ok();
    }

    @DeleteMapping("/delete")
    public ResponseResult delete(@RequestBody Reader reader){
        log.info("AdminController-delete()接收的参数：{}",reader);
        readerServiceImpl.removeById(reader);
        return ResponseResult.ok();
    }

    @PutMapping("/update")
    public ResponseResult update(@RequestBody Reader reader){
        log.info("AdminController-update()接收的参数：{}",reader);
        boolean b = readerServiceImpl.updateById(reader);
        Asserts.fail(b == false, OPTIMISTIC_LOCK_ERROR);
        return ResponseResult.ok();
    }

    @GetMapping("/getById")
    public ResponseResult getById(int id){
        log.info("AdminController-getById()接收的参数：{}",id);
        Reader reader = readerServiceImpl.getById(id);
        return ResponseResult.ok(reader);
    }

    @GetMapping("/findAll")
    public ResponseResult findAll(){
        List<Reader> list = readerServiceImpl.list();
        return ResponseResult.ok(list);
    }

    @GetMapping("/page")
    public ResponseResult find2Page(Integer pageNum, Integer pageSize, ReaderDto readerDto){
        Page<Object> pageRequest = Page.of(pageNum, pageSize);
        Page page = readerServiceImpl.find2Page(pageRequest,readerDto);
        return ResponseResult.ok(page);
    }

}
