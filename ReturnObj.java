package com.bilibili.entity;

import java.util.Map;

public class ReturnObj {
private int status;
private String msg;
private Map<String,String> result;
public static ReturnObj buildSuccess() {
	ReturnObj returnObj = new ReturnObj();
	returnObj.setStatuS(200);
	returnObj.setMsg("success");
	return returnObj;
}
public static ReturnObj buildFault() {
	ReturnObj returnObj = new ReturnObj();
	returnObj.setStatuS(400);
	returnObj.setMsg("fault");
	return returnObj;
}

public int getStatuS() {
	return status;
}
public void setStatuS(int statuS) {
	this.status = statuS;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public Map<String, String> getResult() {
	return result;
}


}
