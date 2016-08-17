package com.intelligentCommunity.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	public static Map<String,String> extMap = new HashMap<String, String>();
	static {
		extMap.put("png", "image/png");
		extMap.put("pdf", "application/pdf");
	}
	
	
	
	private static final long serialVersionUID = 1L;

	public Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}
	
	public HttpServletRequest getHttpServletRequest() {
		return ServletActionContext.getRequest();
	}
	
	public String getUserIp() {
		return getHttpServletRequest().getRemoteAddr();
	}
	
	public void putSession(String key,Object value) {
		getSession().put(key, value);
	}
	
	public void renderJSON(Object obj) throws IOException  {
		String json = new Gson().toJson(obj);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	
	
	public void renderText(Object str) throws IOException  {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}
	
	
}


