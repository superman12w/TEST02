<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<div class="m_des">
            	<table border="0" style="width:870px; line-height:22px;" cellspacing="0" cellpadding="0">
                  <tr valign="top">
                    <td width="115"><img src="${pageContext.request.contextPath }/images/user.jpg" width="90" height="90" /></td>
                    <td>
                    	<div class="m_user">
                    	${sessionScope.loginUser.userName }
                    	</div>
                        <p>
                            等级：注册用户 <br />
                            <font color="#ff4e00">您还差 270 积分达到 分红100</font><br />
                            上一次登录时间: 2015-09-28 18:19:47<br />
                            您还没有通过邮件认证 <a href="#" style="color:#ff4e00;">点此发送认证邮件</a>
                        </p>
                        <div class="m_notice">
                        	用户中心公告！
                        </div>
                    </td>
                  </tr>
                </table>	
            </div>