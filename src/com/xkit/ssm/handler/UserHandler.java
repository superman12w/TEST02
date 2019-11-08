package com.xkit.ssm.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkit.ssm.entity.Easybuy_user;
import com.xkit.ssm.service.Easybuy_userService;
import com.xkit.ssm.tools.PageBean;
import com.xkit.ssm.validator.UserLogin;
import com.xkit.ssm.validator.UserRegist;
@Controller
public class UserHandler {
	@Autowired
	private Easybuy_userService userService;
	@RequestMapping("/manage/delUser/{id}")
	public String delUser(@PathVariable("id")Integer id,Model m) throws Exception{
		boolean isok=userService.deleteUser(id);
		if (isok) {
			m.addAttribute("msg", "É¾³ý³É¹¦£¡");
			return "forward:/manage/queryUser";
		}else{
			m.addAttribute("msg", "É¾³ýÊ§°Ü£¡");
			return "forward:/manage/queryUser";
		}
	}
	
	@RequestMapping("/manage/queryUser")
	public String queryUser(@RequestParam(defaultValue="1") Integer pageIndex,Easybuy_user user,Model m) throws Exception{
		int record=userService.countUser(user);
		int pageSize=2;
		int pageCount=record%pageSize==0?record/pageSize:record/pageSize+1;
		if (pageIndex<1 || pageIndex>pageCount) {
			pageIndex=1;
		}
		List<Easybuy_user> list = userService.queryUserByPage((pageIndex-1)*pageSize, pageSize, user);
		PageBean pb=new PageBean();
		pb.setDataList(list);
		pb.setPageCount(pageCount);
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		pb.setRecord(record);
		m.addAttribute("pagebean", pb);
		return "WEB-INF/pages/manage/userList";
	}
	
	
	
	@RequestMapping("/login")
	public String login(@Validated(value={UserLogin.class}) Easybuy_user param ,BindingResult r, Model m,HttpSession session) throws Exception{
		if (r.hasFieldErrors()) {
			return "login";
		}
		Easybuy_user user = userService.UserLogin(param.getLoginName(),param.getPassword());
		if (user==null) {
			m.addAttribute("msg","µÇÂ½Ê§°Ü£¡");
			return "login";
		}else{
			m.addAttribute(user);
			session.setAttribute("loginUser", user);
			return "WEB-INF/pages/manage/main";
		}
	}
	@RequestMapping("/reg")
	public String regist(@Validated(value=UserRegist.class) Easybuy_user user,BindingResult r,Model m) throws Exception{
		if (r.hasFieldErrors()) {
			return "regist";
		}else{
			boolean isok=userService.addUser(user);
			if (isok) {
				m.addAttribute("msg","×¢²á³É¹¦£¡");
				return "login";
			}else{
				m.addAttribute("msg","×¢²áÊ§°Ü£¡");
				return "regist";
			}
		}
	}
	@RequestMapping(value="/checkLoginName")
	public @ResponseBody String checkLoginName(String zh) throws Exception{
		boolean isok=userService.checkLoginUsed(zh);
		String rs="{\"msg\":0}";
		if (isok) {
			rs="{\"msg\":1}";
		}
		return rs;
	}
	@RequestMapping("/manage/welcome")
	public String welcome(){
		return "WEB-INF/pages/manage/welcome";
	}
	
	
	
	@RequestMapping(value="/showUserList")
	public @ResponseBody List<Easybuy_user> showUserList() throws Exception{
		List<Easybuy_user> list = userService.queryUser();
		return list;
	}
	
}
