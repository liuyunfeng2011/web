package com.gezhi.supervise.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.stereotype.Component;

import com.gezhi.supervise.pojo.User;
import com.gezhi.supervise.pojo.authorize.Permission;
import com.gezhi.supervise.pojo.authorize.Role;
import com.gezhi.supervise.service.UserService;
import com.gezhi.supervise.service.authorize.PermissionService;
import com.gezhi.supervise.service.authorize.RoleService;
import com.gezhi.supervise.util.ResultCode;
@Component("userRealm")
public class UserRealm extends AuthorizingRealm{
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="roleService")
	private RoleService roleService;
	@Resource(name="permissionService")
	private PermissionService permissionService;
	//为当前用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		String userName=(String) principals.getPrimaryPrincipal();
		User user=userService.getUserByName(userName);
		List<Role> roles=roleService.selectRolesByUserId(user.getUserId());
		for(Role r : roles){
			authorizationInfo.addRole(r.getRoleSign());
			List<Permission> permissions=permissionService.selectPermissionsByRoleId(r.getRoleId());
			for(Permission p:permissions){
				authorizationInfo.addStringPermission(p.getPermissionSign());
			}
		}
		//添加了权限
		return authorizationInfo;
	}
	//验证当前的用户doGetAuthorizationInfo
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String name=(String) token.getPrincipal();
		String pwd=new String((char[])token.getCredentials());
		User user= userService.authentication(new User(name,pwd));
		if(user==null){
			//用户名/密码不匹配
			throw new AuthenticationException(ResultCode.LOGIN_FAIL.msg());
		}else if(user.getUserType()==0){
			//账户已被禁用
			throw new DisabledAccountException(ResultCode.ACCOUNT_LOCK.msg());
		}
			//根据取得的值构建authorizationInfo对象
		System.out.println(name);
			SimpleAuthenticationInfo authorizationInfo=new SimpleAuthenticationInfo(name,pwd,getName());
			return authorizationInfo;
	}

	/** 
     * 清除用户授权信息缓存. 
     */  
    public void clearCachedAuthorizationInfo(String principal) {  
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());  
        clearCachedAuthorizationInfo(principals);  
    }  
    /** 
     * 清除所有用户授权信息缓存. 
     */  
    public void clearAllCachedAuthorizationInfo() {  
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();  
        if (cache != null) {  
            for (Object key : cache.keys()) {  
                cache.remove(key);  
            }  
        }  
    }  
    /** 
     *  
    * @Title: clearAuthz  
    * @Description: TODO 清楚缓存的授权信息   
    * @return void    返回类型 
     */  
    public void clearAuthz(){  
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());  
    }
}
