package com.wangsd.web.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsd.web.mapper.SysUserMapper;
import com.wangsd.web.mapper.SysUserRoleMapper;
import com.wangsd.web.model.SysUser;
import com.wangsd.web.model.SysUserRole;
import com.wangsd.web.service.ISysUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    SysUserRoleMapper userRoleMapper;

    /**
     * 保存用户
     */
    @Override
    public void insertUser(SysUser user, Long[] roleIds) {
        //保存用户
        this.insert(user);

        //绑定角色
        if(ArrayUtils.isNotEmpty(roleIds)){
            for(Long rid : roleIds){
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(user.getId());
                sysUserRole.setRoleId(rid);
                userRoleMapper.insert(sysUserRole);
            }
        }
    }


}
