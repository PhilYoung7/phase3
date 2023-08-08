package com.woniuxy.operate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.woniuxy.operate.entity.Borrow;
import com.woniuxy.operate.service.IBorrowService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-05
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {

    private final IBorrowService borrowServiceImpl;

    public BorrowController(IBorrowService borrowServiceImpl){
        this.borrowServiceImpl = borrowServiceImpl;
    }

}
