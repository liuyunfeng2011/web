package com.gezhi.supervise.service.authorize.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gezhi.supervise.mapper.authorize.PermissionMapper;
import com.gezhi.supervise.pojo.authorize.Permission;
import com.gezhi.supervise.service.authorize.PermissionService;

@Service("permissionService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
public class PermissionServiceImpl  implements PermissionService{
	@Resource
	private PermissionMapper permissionMapper;

	public List<Permission> selectPermissionsByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return permissionMapper.selectPermissionsByRoleId(roleId);
	}

}
