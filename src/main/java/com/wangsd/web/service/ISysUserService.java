package com.wangsd.web.service;

import com.wangsd.web.model.SysUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wangsd
 * @since 2018-01-01
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 保存用户
     */
    void insertUser(SysUser user, Long[] roleId);
}
