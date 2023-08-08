package com.woniuxy.operate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operate.dto.ReaderDto;
import com.woniuxy.operate.entity.Book;
import com.woniuxy.operate.entity.Reader;
import com.woniuxy.operate.mapper.ReaderMapper;
import com.woniuxy.operate.service.IReaderService;
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
public class ReaderServiceImpl extends ServiceImpl<ReaderMapper, Reader> implements IReaderService {

    private final ReaderMapper readerMapper;

    public ReaderServiceImpl(ReaderMapper readerMapper){
        this.readerMapper = readerMapper;
    }

    @Override
    public Page find2Page(Page pageRequest, ReaderDto readerDto) {
        //创建一个条件查询器
        LambdaQueryWrapper<Reader> lqw = new LambdaQueryWrapper<>();
        lqw.likeRight(StringUtils.hasLength(readerDto.getName()),Reader::getName,readerDto.getName());
        lqw.likeRight(StringUtils.hasLength(readerDto.getIdCard()),Reader::getIdCard,readerDto.getIdCard());
        //根据ID进行降序查询
        lqw.orderByAsc(Reader::getReaderId);

        Page page = readerMapper.selectPage(pageRequest, lqw);
        return page;
    }
}
