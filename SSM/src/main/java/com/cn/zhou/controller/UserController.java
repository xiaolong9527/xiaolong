package com.cn.zhou.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.zhou.entity.User;
import com.cn.zhou.helper.SpringContextHolder;
import com.cn.zhou.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		//测试SpringContextHolder是否有作用
		System.out.println("1111");
		System.out.println(SpringContextHolder.getBean(User.class));
		
		System.out.println(getDBInfo().get("jdbc.type"));
		System.out.println(request.getSession().getServletContext().getRealPath(""));
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	public Map<String, String> getDBInfo() {
	    Map<String, String> dbInfo = new HashMap<String, String>();
	    try {
	        String url = this.getClass().getResource("").getPath();
	        System.out.println(url);
	        String path = url.substring(0, url.indexOf("WEB-INF")) + "WEB-INF/db.properties";
	        System.out.println(path);
	        Properties config = new Properties();  
	        InputStream in = new FileInputStream(path);
	        config.load(in); 	        
	        dbInfo.put("jdbc.type", config.getProperty("jdbc.type"));	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dbInfo;
	     
	}
}