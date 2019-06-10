package com.gezhi.supervise.service.authorize.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gezhi.supervise.mapper.authorize.RoleMapper;
import com.gezhi.supervise.pojo.authorize.Role;
import com.gezhi.supervise.service.authorize.RoleService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("roleService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleMapper mapper;

	public List<Role> selectRolesByUserId(int userId) {
		// TODO Auto-generated method stub
		return mapper.selectRolesByUserId(userId);
	}


}
