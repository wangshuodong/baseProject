package com.wangsd.common.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wangsd.web.model.SysUser;
import com.wangsd.web.service.ISysUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description：shiro权限认证
 * @author：zhixuan.wang
 * @date：2015/10/1 14:51
 */
public class ShiroDbRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LogManager.getLogger(ShiroDbRealm.class);

    @Autowired
    private ISysUserService userService;
//    @Autowired private IRoleService roleService;
    
    public ShiroDbRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }
    
    /**
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        LOGGER.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        SysUser sysUser = userService.selectOne(new EntityWrapper<SysUser>().eq("loginName", token.getUsername()));
        // 账号不存在
        if (sysUser == null) {
            throw new UnknownAccountException();
        }
        // 账号未启用
        if (sysUser.getUserState() == 0) {
            throw new LockedAccountException();
        }
        // 读取用户的url和角色
//        Map<String, Set<String>> resourceMap = roleService.selectResourceMapByUserId(sysUser.getId());
//        Set<String> urls = resourceMap.get("urls");
//        Set<String> roles = resourceMap.get("roles");
        ShiroUser shiroUser = new ShiroUser(sysUser.getId(), sysUser.getLoginName(), sysUser.getUserName(), null);
//        shiroUser.setRoles(roles);
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, sysUser.getPassword().toCharArray(),
                ShiroByteSource.of(sysUser.getSalt()), getName());
    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(shiroUser.getRoles());
        info.addStringPermissions(shiroUser.getUrlSet());
        
        return info;
    }

    @Override
    protected Object getAuthenticationCacheKey(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) super.getAvailablePrincipal(principals);
        return shiroUser.toString();
    }

    @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) super.getAvailablePrincipal(principals);
        return shiroUser.toString();
    }

    /**
     * 清除用户缓存
     * @param shiroUser
     */
    public void removeUserCache(ShiroUser shiroUser){
        removeUserCache(shiroUser.getLoginName());
    }

    /**
     * 清除用户缓存
     * @param loginName
     */
    public void removeUserCache(String loginName){
        SimplePrincipalCollection principals = new SimplePrincipalCollection();
        principals.add(loginName, super.getName());
        super.clearCachedAuthenticationInfo(principals);
    }
}
