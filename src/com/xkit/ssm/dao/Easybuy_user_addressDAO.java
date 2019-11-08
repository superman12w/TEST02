package com.xkit.ssm.dao;

import java.util.List;

import com.xkit.ssm.entity.Easybuy_user_address;

public interface Easybuy_user_addressDAO {
	public int add(Easybuy_user_address addr);
	public List<Easybuy_user_address> queryAddress();
}
