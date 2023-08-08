package com.woniuxy.operate.controller;

import org.springframework.web.bind.annotation.*;
import com.woniuxy.operate.service.ICollectionService;
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
@RequestMapping("/collection")
public class CollectionController {

    private final ICollectionService collectionServiceImpl;

    public CollectionController(ICollectionService collectionServiceImpl){
        this.collectionServiceImpl = collectionServiceImpl;
    }

}
