package com.gezhi.supervise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gezhi.supervise.util.JsonResult;
import com.gezhi.supervise.util.ResultCode;

@Controller
@ResponseBody
public class FirstController {
	@GetMapping(value="sayHello.do")
	public JsonResult sayHello(){
		return new JsonResult(ResultCode.SUCCESS);
	}
}
