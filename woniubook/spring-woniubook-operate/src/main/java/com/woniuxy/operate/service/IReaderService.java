package com.woniuxy.operate.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operate.dto.ReaderDto;
import com.woniuxy.operate.entity.Reader;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-05
 */
public interface IReaderService extends IService<Reader> {

    Page find2Page(Page pageRequest, ReaderDto readerDto);
}
