package com.woniuxy.operate.service.impl;

import com.woniuxy.operate.entity.Borrow;
import com.woniuxy.operate.mapper.BorrowMapper;
import com.woniuxy.operate.service.IBorrowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-05
 */
@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper, Borrow> implements IBorrowService {

    private final BorrowMapper borrowMapper;

    public BorrowServiceImpl(BorrowMapper borrowMapper){
        this.borrowMapper = borrowMapper;
    }

}
