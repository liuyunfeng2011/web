package com.gezhi.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gezhi.pojo.User;

public class JackSonUtil {
	public static void main(String[] args) throws JsonProcessingException {
		User user = new User(1, "zhangsan", 1);
		User user2 = new User(2, "zhangsan2", 1);
		User user3 = new User(3, "zhangsan3", 1);
		List<User> list = new ArrayList<>();
		list.add(user);
		list.add(user2);
		list.add(user3);
		System.out.println(list); //java格式
		ObjectMapper mapper = new ObjectMapper();
		String jsonlist = mapper.writeValueAsString(list);
		System.out.println(jsonlist);//json格式
	}
}
