package com.wangsd.web.service.impl;

import com.wangsd.web.model.SysUser;
import com.wangsd.web.mapper.SysUserMapper;
import com.wangsd.web.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wangsd
 * @since 2018-01-01
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
