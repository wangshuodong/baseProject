package com.wangsd.web.service;

import com.wangsd.web.model.SysRoleMenu;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 角色菜单关联表 服务类
 * </p>
 *
 * @author wangsd
 * @since 2018-01-01
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 角色授权
     */
    void addAuth(Long roleId, Long[] menuIds);

}
