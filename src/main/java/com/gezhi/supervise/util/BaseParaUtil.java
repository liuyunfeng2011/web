package com.gezhi.supervise.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 存放一些重要参数 主要从properties中读取
 * @author Liuyf
 *
 */
@Component("baseParaUtil")
public class BaseParaUtil {
	//密码盐
	@Value("${salt}")
	private String salt;

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
