package com.gezhi.supervise.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gezhi.supervise.pojo.User;
import com.gezhi.supervise.service.UserService;
import com.gezhi.supervise.util.BaseParaUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional
public class UserServiceImplTest {
	@Resource(name="userService")
	private UserService UserService;
	@Resource(name="baseParaUtil")
	private BaseParaUtil baseParaUtil;
	@Ignore
	@Test
	public void testGetUserByName() {
		try {
//			User user=UserService.getUserByName("root");
//			System.out.println(user);
//		System.out.println(passCoder.encode(baseParaUtil.getSalt(), "admin"));	
			SimpleHash simpleHash =new SimpleHash("MD5","admin","Z2V6aGk=",1024);
			System.out.println(simpleHash);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
