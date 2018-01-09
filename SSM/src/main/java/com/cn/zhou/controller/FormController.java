package com.cn.zhou.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.zhou.entity.TagsModel;
import com.cn.zhou.entity.User;
import com.cn.zhou.helper.SpringContextHolder;
import com.cn.zhou.service.IUserService;


@Controller
@RequestMapping(value = "/form")
public class FormController {
	/**
	 * 会对应jsp页面的modelAttribute
	 * 每次到达controller时候都会被该方法拦截
	 * 
	 */
	@ModelAttribute	
	public	TagsModel get(@RequestParam(required=false) String id) {
		// 获取传过来的id参数
		if (id!=null){
			// 如果不为空查询后返回一个有值的实体类
			return null;
		}else{
			// 如果为空重新new一个实体
			return new TagsModel();
		}
	}
	
	@RequestMapping(value="/testform", method = {RequestMethod.GET})
	public String form(HttpServletRequest request,HttpServletResponse response,TagsModel tagsModel,Model model){
		System.out.println(tagsModel.getUsername());
		System.out.println("11111111111111");
		
		model.addAttribute("value", "可以啊");
		return "showtime";
	}
	
	
	

	
}
