package com.xkit.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xkit.ssm.entity.Easybuy_user;
//用户表操作service接口
public interface Easybuy_userService {
	public boolean deleteUser(Integer id)throws Exception;
	public Easybuy_user UserLogin(String zh,String mm) throws Exception;
	public boolean addUser(Easybuy_user user) throws Exception;
	public boolean checkLoginUsed(String zh) throws Exception;
	
	public List<Easybuy_user> queryUser()throws Exception;
	public List<Easybuy_user> queryUserByPage(int pageIndex,
			int pageSize,
			Easybuy_user user)throws Exception;
	public int countUser(Easybuy_user user)throws Exception;
}
