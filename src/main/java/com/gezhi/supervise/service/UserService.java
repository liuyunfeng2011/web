package com.gezhi.supervise.service;


import com.gezhi.supervise.pojo.User;

public interface UserService {
	/**
	 * 用户登录验证
	 * @param user
	 * @return
	 */
	User authentication(User user) ;
	/**
	 * 根据用户名获取用户信息
	 * @param name
	 * @return
	 */
	User getUserByName(String name) ;
}
