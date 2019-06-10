package com.gezhi.supervise.mapper.authorize;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gezhi.supervise.pojo.authorize.Role;


public interface RoleMapper {
	public List<Role> selectRolesByUserId(int userId);
}
