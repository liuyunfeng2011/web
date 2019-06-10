package com.gezhi.supervise.service.authorize;

import java.util.List;

import com.gezhi.supervise.pojo.authorize.Permission;


/**
 * 权限 业务接口
 * 
 * @author liuyf
 **/
public interface PermissionService {

	/**
	 * 通过角色id 查询角色 拥有的权限
	 * 
	 * @param roleId
	 * @return
	 */
	List<Permission> selectPermissionsByRoleId(int roleId);

}
