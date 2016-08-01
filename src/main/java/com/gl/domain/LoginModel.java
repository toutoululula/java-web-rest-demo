package com.gl.domain;

import org.springframework.stereotype.Component;

@Component("loginModel")
public class LoginModel {
private boolean success;
private String msg;
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
}
