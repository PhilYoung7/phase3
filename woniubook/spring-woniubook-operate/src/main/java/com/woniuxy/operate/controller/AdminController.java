package com.woniuxy.operate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operate.dto.AdminDto;
import com.woniuxy.operate.entity.Admin;
import com.woniuxy.operate.pojos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.woniuxy.operate.service.IAdminService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/admin")
public class AdminController {

    private final IAdminService adminServiceImpl;

    public AdminController(IAdminService adminServiceImpl){
        this.adminServiceImpl = adminServiceImpl;
    }

    @PostMapping("/add")
    public ResponseResult add(@RequestBody Admin admin){
        log.info("AdminController-add()接收的参数：{}",admin);
        adminServiceImpl.save(admin);
        return ResponseResult.ok();
    }

    @DeleteMapping("/delete")
    public ResponseResult delete(@RequestBody Admin admin){
        log.info("AdminController-delete()接收的参数：{}",admin);
        adminServiceImpl.removeById(admin);
        return ResponseResult.ok();
    }

    @PutMapping("/update")
    public ResponseResult update(@RequestBody Admin admin){
        log.info("AdminController-update()接收的参数：{}",admin);
        adminServiceImpl.updateById(admin);
        return ResponseResult.ok();
    }

    @GetMapping("/getById")
    public ResponseResult getById(int id){
        log.info("AdminController-getById()接收的参数：{}",id);
        Admin admin = adminServiceImpl.getById(id);
        return ResponseResult.ok(admin);
    }

    @GetMapping("/findAll")
    public ResponseResult findAll(){
        List<Admin> list = adminServiceImpl.list();
        return ResponseResult.ok(list);
    }

    @GetMapping("/page")
    public ResponseResult find2Page(Integer pageNum, Integer pageSize, AdminDto adminDto){
        Page<Object> pageRequest = Page.of(pageNum, pageSize);
        Page page = adminServiceImpl.find2Page(pageRequest,adminDto);
        return ResponseResult.ok(page);
    }
}
