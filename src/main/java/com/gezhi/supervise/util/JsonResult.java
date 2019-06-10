package com.gezhi.supervise.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResult {
	private String success;
	private String message;
	private Object data;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(ResultCode code) {
		this.success = code.val();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JsonResult() {
		this.setSuccess(ResultCode.SUCCESS);
	}

	// code +message
	public JsonResult(ResultCode code) {
		this.setSuccess(code);
	}
	
	// code +message
		public JsonResult(ResultCode code,String message) {
			this.setSuccess(code);
			this.setMessage(message);
		}

	// code+message+data
	public JsonResult(ResultCode code, Object data) {
		this.setSuccess(code);
		this.setMessage(message);
		this.setData(data);
	}
}
