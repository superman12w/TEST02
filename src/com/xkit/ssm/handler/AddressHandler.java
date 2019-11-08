package com.xkit.ssm.handler;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xkit.ssm.entity.Easybuy_user;
import com.xkit.ssm.entity.Easybuy_user_address;
import com.xkit.ssm.service.Easybuy_userService;
import com.xkit.ssm.service.Easybuy_user_addressService;

@Controller
public class AddressHandler {
	@Autowired
	private Easybuy_userService userService;
	@Autowired
	private Easybuy_user_addressService addressService;
	
	
	@RequestMapping("/deleteAddress/{abc}/{bcd}")
	public String delAddress(@PathVariable("abc") Integer id,@PathVariable("bcd") Integer userId){
		System.out.println("获得的ID是："+id);
		return "addressList";
	}
	
	@RequestMapping("/initAddAddress")
	public String initAddAddress() throws Exception{
		return "WEB-INF/pages/addAddress";
	}
	
	@RequestMapping("/addAddress")
	public String addAddress(Easybuy_user_address address,Model m){
//		address.setCreateTime(new Date());
		if (address.getIsDefault()==null) {
			address.setIsDefault(0);
		}
		boolean isok=addressService.addAddress(address);
		if (isok) {
			m.addAttribute("msg", "新增地址成功！");
		}else{
			m.addAttribute("msg", "新增地址失败！");
		}
		return "WEB-INF/pages/addAddress";
	}
	@ModelAttribute("userlist")
	public List<Easybuy_user> getUsers() throws Exception{
		List<Easybuy_user> list = userService.queryUser();
		return list;
	}
	@RequestMapping("/initUpload")
	public String initUpload(){
		return "WEB-INF/pages/testUpload";
	}
	@RequestMapping("/upload")
	public String upload(@RequestParam("photo") MultipartFile [] photo,HttpServletRequest req,Model m) throws IllegalStateException, IOException{
		for (MultipartFile multipartFile : photo) {
			String fileName=multipartFile.getOriginalFilename();
			File file=new File(req.getRealPath("/")+"/photo/"+fileName);
			multipartFile.transferTo(file);
		}
		m.addAttribute("msg", "上传成功！");
		return "WEB-INF/pages/testUpload";
	}
	@RequestMapping("/queryAddress")
	@ResponseBody
	public List<Easybuy_user_address> queryAddress() throws IllegalStateException, IOException{
		 return addressService.queryEasybuy_user_address();
	}
}
