package com.cn.zhou.test;

import java.util.Arrays;

import com.cn.zhou.dao.UserDao;
import com.cn.zhou.entity.User;
import com.cn.zhou.helper.SpringContextHolder;
import com.cn.zhou.service.IUserService;




public class Testing {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(1,2));
		IUserService user = SpringContextHolder.getBean(IUserService.class);
//		test();
	}
	
	public static void test(){
		User user = SpringContextHolder.getBean(UserDao.class).get(1);
		System.out.println(user.toString());
	}
}
