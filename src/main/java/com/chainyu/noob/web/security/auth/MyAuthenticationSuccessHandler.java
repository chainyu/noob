/**
 * Copyright (c) 2010 Jumbomart All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Jumbomart.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jumbo.
 *
 * JUMBOMART MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. JUMBOMART SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.chainyu.noob.web.security.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson.JSON;
import com.baozun.nebulaplus.constant.ScopeConstants;
import com.baozun.nebulaplus.http.RequestUtil;
import com.baozun.nebulaplus.web.MyUserDetails;
import com.baozun.service.auth.api.ReservedMenuService;
import com.baozun.service.auth.api.ReservedPrivilegeUrlService;
import com.baozun.service.auth.api.ReservedUserLoginLogService;
import com.baozun.service.auth.api.ReservedUserService;
import com.baozun.service.auth.command.MenuCommand;
import com.baozun.service.auth.model.User;
import com.baozun.service.auth.model.UserLoginLog;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private ReservedUserService reservedUserService;

	@Autowired
	private ReservedMenuService reservedMenuService;

	@Autowired
	private ReservedPrivilegeUrlService privilegeUrlService;
	
	@Autowired
	private ReservedUserLoginLogService  reservedUserLoginLogService;

	/*
	 * 登录成功后，加载用户可访问菜单，记录登录日志
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

		request.getSession().setAttribute(ScopeConstants.SESSION_MENU_CONTEXT,
				JSON.toJSONString(loadUserMenu(userDetails)));
		// 登陆成功后记录日志
		reservedUserService.updateLatestLoginTime(userDetails.getUser().getId().intValue());
		insertLoginSuccesslog(request,userDetails.getUser());
        if(userDetails.getMustChangePwd()){
        	response.sendRedirect("reset.htm");
        }else{
        	response.sendRedirect("index.htm");
        }
	}

	/**
	 * 用户可以访问的菜单列表
	 * 
	 * @param userDetails
	 * @return
	 */
	private List<MenuCommand> loadUserMenu(MyUserDetails userDetails) {
		List<String> urls =null;
		if(userDetails.getIsAdmin()){
			//根据店铺id获取该店铺的菜单
			urls =privilegeUrlService.findEffectivePrivilegeUrlListByStoreId(userDetails.getUser().getStoreId(), false);
		}else{
			// 根据角色Ids获取所有用于构造菜单的权限url
			List<GrantedAuthority> authorities = (List<GrantedAuthority>) userDetails.getAuthorities();

			List<Long> roleIds = new ArrayList<Long>();
			for (GrantedAuthority authoritie : authorities) {
				roleIds.add(Long.valueOf(authoritie.toString()));
			}

			urls = privilegeUrlService.findEffectivePrivilegeUrlListByRoleIdsAndStoreId(roleIds,
					userDetails.getUser().getStoreId());
		}
	

		return reservedMenuService.findMenuByUrls(urls);

	}
	
	/**
	 * 插入登录成功日志
	 * @param req
	 * @param exception
	 */
	private void insertLoginSuccesslog(HttpServletRequest req ,User user){
		UserLoginLog log = new UserLoginLog();
		log.setIp(RequestUtil.getClientIp(req));
		log.setSessionId(req.getSession().getId());
		log.setStatus(UserLoginLog.USER_LOGIN_SUCCESS);
		log.setStoreId(user.getStoreId());
		log.setUserId(user.getId());
		
		reservedUserLoginLogService.save(log);
	}

}
