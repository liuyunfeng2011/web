package com.gezhi.supervise.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gezhi.supervise.pojo.User;
import com.gezhi.supervise.service.UserService;
import com.gezhi.supervise.util.JsonResult;

@Controller
@ResponseBody
@RequestMapping("user")
public class UserCotroller {
	@Resource(name="userService")
	private UserService userService;
	@PostMapping(value="login")
	public JsonResult Login(String name,String pwd){
		try {
			Subject subject = SecurityUtils.getSubject();
			//md5加密密码 需要补充
			subject.login(new UsernamePasswordToken(name, pwd));
			User user=userService.getUserByName(name);
		}catch(IncorrectCredentialsException ice){
			System.out.println("用户名/密码不正确");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}
	@GetMapping(value="testShiro")
	public void test1(){
		Subject subject = SecurityUtils.getSubject();
		System.out.println(subject.getPrincipal());
		System.out.println(subject.getSession().getTimeout());
		System.out.println(subject.hasRole("root"));
		System.out.println(subject.hasRole("user"));
	}
}
