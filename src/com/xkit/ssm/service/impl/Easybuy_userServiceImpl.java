package com.xkit.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkit.ssm.dao.Easybuy_userDAO;
import com.xkit.ssm.entity.Easybuy_user;
import com.xkit.ssm.service.Easybuy_userService;
//用户表操作service接口实现类
@Service
public class Easybuy_userServiceImpl implements Easybuy_userService {
	@Autowired
	private Easybuy_userDAO dao;
	public Easybuy_user UserLogin(String zh,String mm) throws Exception{
		Easybuy_user user=dao.get(zh, mm);
		return user;
	}
	//用户注册，返回true代表注册成功，false代表注册失败
	public boolean addUser(Easybuy_user user) throws Exception{
		int count=dao.insert(user);
		if (count==1) {
			return true;
		}
		return false;
	}
	
	public boolean checkLoginUsed(String zh) throws Exception{
		return dao.getCount(zh)==0;
	}
	
	public Easybuy_userDAO getDao() {
		return dao;
	}
	public void setDao(Easybuy_userDAO dao) {
		this.dao = dao;
	}
	public List<Easybuy_user> queryUser() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectUser();
	}
	public List<Easybuy_user> queryUserByPage(int pageIndex, int pageSize,
			Easybuy_user user) throws Exception {
		return dao.selectUserByPage(pageIndex, pageSize, user);
	}
	public int countUser(Easybuy_user user) throws Exception {
		// TODO Auto-generated method stub
		return dao.count(user);
	}
	public boolean deleteUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(id)>0;
	}
	
	
	
	
}
