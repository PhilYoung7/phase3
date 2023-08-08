package com.woniuxy.operate.service.impl;

import com.woniuxy.operate.entity.CollectionEntity;
import com.woniuxy.operate.mapper.CollectionMapper;
import com.woniuxy.operate.service.ICollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-05
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, CollectionEntity> implements ICollectionService {

    private final CollectionMapper collectionMapper;

    public CollectionServiceImpl(CollectionMapper collectionMapper){
        this.collectionMapper = collectionMapper;
    }

}
