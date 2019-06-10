package com.gezhi.supervise.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gezhi.supervise.mapper.UserMapper;
import com.gezhi.supervise.pojo.User;
import com.gezhi.supervise.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.selectByUsername(name);
	}
	public User authentication(User user) {
		// TODO Auto-generated method stub
		User users = userMapper.authentication(user);
		return users;
	}

}
