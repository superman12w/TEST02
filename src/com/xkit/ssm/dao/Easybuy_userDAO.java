package com.xkit.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xkit.ssm.entity.Easybuy_user;
//用户表操作dao接口
public interface Easybuy_userDAO {
	public Easybuy_user get(@Param("zh") String zh,@Param("mm") String mm) throws Exception;
	public int insert(Easybuy_user user) throws Exception;
	public int getCount(String zh) throws Exception;
	public List<Easybuy_user> selectUser()throws Exception;
	public List<Easybuy_user> selectUserByPage(@Param("pageIndex")int pageIndex,
			@Param("pageSize") int pageSize,
			@Param("user") Easybuy_user user)throws Exception;
	public int count(Easybuy_user user)throws Exception;
	public int delete(Integer id)throws Exception;
}
