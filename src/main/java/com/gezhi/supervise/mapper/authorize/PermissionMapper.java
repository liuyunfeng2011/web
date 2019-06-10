package com.gezhi.supervise.mapper.authorize;

import java.util.List;

import com.gezhi.supervise.pojo.authorize.Permission;



/**
 * 权限 Dao 接口 注释
 * 
 * @author liuyf
 **/
public interface PermissionMapper  {

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(int roleId);


}