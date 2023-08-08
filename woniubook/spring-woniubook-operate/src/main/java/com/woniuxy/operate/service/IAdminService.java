package com.woniuxy.operate.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.operate.dto.AdminDto;
import com.woniuxy.operate.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author woniuxy
 * @since 2023-08-05
 */
public interface IAdminService extends IService<Admin> {

    Page find2Page(Page pageRequest, AdminDto adminDto);
}
