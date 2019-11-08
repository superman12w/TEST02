package com.xkit.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkit.ssm.dao.Easybuy_user_addressDAO;
import com.xkit.ssm.entity.Easybuy_user_address;
import com.xkit.ssm.service.Easybuy_user_addressService;
@Service
public class Easybuy_user_addressServiceImpl implements
		Easybuy_user_addressService {
	@Autowired
	private Easybuy_user_addressDAO addrDao;
	public boolean addAddress(Easybuy_user_address addr) {
		return addrDao.add(addr)>0;
	}
	public List<Easybuy_user_address> queryEasybuy_user_address() {
		// TODO Auto-generated method stub
		return addrDao.queryAddress();
	}

}
