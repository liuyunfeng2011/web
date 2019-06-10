package com.gezhi.supervise.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gezhi.supervise.pojo.User;
import com.gezhi.supervise.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional
public class UserServiceImplTest {
	@Resource(name="userService")
	private UserService UserService;
	@Ignore
	@Test
	public void testGetUserByName() {
		try {
			User user=UserService.getUserByName("root");
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
