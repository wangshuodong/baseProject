package com.wangsd.web.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wangsd.web.model.SysRoleMenu;
import com.wangsd.web.mapper.SysRoleMenuMapper;
import com.wangsd.web.service.ISysRoleMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色菜单关联表 服务实现类
 * </p>
 *
 * @author wangsd
 * @since 2018-01-01
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

    /**
     * 角色授权
     */
    @Override
    public void addAuth(Long roleId, Long[] menuIds) {
        //删除原有权限
        this.delete(new EntityWrapper<SysRoleMenu>().eq("roleId", roleId));

        //从新授权
        if(ArrayUtils.isNotEmpty(menuIds)){
            for(Long menuId : menuIds){
                SysRoleMenu sysRoleMenu2 = new SysRoleMenu();
                sysRoleMenu2.setRoleId(roleId);
                sysRoleMenu2.setMenuId(menuId);
                this.insert(sysRoleMenu2);
            }
        }
    }
}
