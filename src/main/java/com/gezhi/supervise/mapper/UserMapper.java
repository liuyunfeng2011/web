package com.gezhi.supervise.mapper;

import org.apache.ibatis.annotations.Param;

import com.gezhi.supervise.pojo.User;

public interface UserMapper {
	/**
	 *根据用户名、密码查询用户信息
	 * @param user
	 * @return
	 */
	User authentication(@Param("user") User user);

	/**
	 * 根据用户名查询用户信息
	 * @param name
	 * @return
	 */
	User selectByUsername(@Param("name") String name);
}
