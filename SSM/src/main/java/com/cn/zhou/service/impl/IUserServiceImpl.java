package com.cn.zhou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.zhou.dao.UserDao;
import com.cn.zhou.entity.User;
import com.cn.zhou.service.IUserService;

@Service
public class IUserServiceImpl implements IUserService{
	@Autowired
	UserDao userDao;
	
	@Override
	public User getUserById(int id) {
		
		return userDao.get(id);
	}

}
