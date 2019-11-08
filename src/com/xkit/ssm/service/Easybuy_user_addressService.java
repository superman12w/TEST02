package com.xkit.ssm.service;

import java.util.List;

import com.xkit.ssm.entity.Easybuy_user_address;

public interface Easybuy_user_addressService {
	public boolean addAddress(Easybuy_user_address addr);
	public List<Easybuy_user_address> queryEasybuy_user_address();
}
