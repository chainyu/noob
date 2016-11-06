package com.chainyu.noob.web.manager.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import com.chainyu.noob.model.auth.command.PrivilegeUrlRoleCommand;
import com.chainyu.noob.service.auth.PrivilegeUrlService;
import com.chainyu.noob.utils.Validator;


/**
 * @author chainyu_zhang
 * @date 2016年11月1日 下午10:21:31
 */
@Service
public class MetadataSourceManagerImpl implements
		FilterInvocationSecurityMetadataSource {
	
	@Autowired
	private PrivilegeUrlService privilegeUrlService;
	
	private RequestMatcher pathMatcher;
	
	/**
	 * Key(URL)、Value(角色id集合)
	 */
	public static Map<String, Collection<ConfigAttribute>> resourceMap = null;


	public MetadataSourceManagerImpl() {
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return new ArrayList<ConfigAttribute>();
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	
	/**
	 * 
	 * 加载所有 Key(URL)、Value(角色id集合)数据
	 * @throws Exception
	 */
	@PostConstruct
	public void loadResourceDefine() throws Exception {
		Map<String, Collection<ConfigAttribute>> localResourceMap =new HashMap<String, Collection<ConfigAttribute>>();
		List<PrivilegeUrlRoleCommand> urlRoleCommands =privilegeUrlService.findAllPrivilegeUrlRoles();
		if(Validator.isNotNullOrEmpty(urlRoleCommands)){
			for (PrivilegeUrlRoleCommand privilegeUrlRoleCommand : urlRoleCommands) {
				String url=privilegeUrlRoleCommand.getUrl();
				List<String> roleIds = privilegeUrlRoleCommand.getRoleIds();
				if(Validator.isNotNullOrEmpty(roleIds)){
					Collection<ConfigAttribute> attributes=new ArrayList<ConfigAttribute>();
					for (String roleId : roleIds) {
						attributes.add(new SecurityConfig(roleId));
					}
					localResourceMap.put(url, attributes);
				}
			}
		}
		resourceMap = localResourceMap;
	}

	// 返回所请求资源所需要的角色ids集合
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		String reqUrl =((FilterInvocation) object).getRequestUrl();
		if(Validator.isNotNullOrEmpty(resourceMap)){
			Collection<ConfigAttribute> configAttributes =null;
			String urlKey ="";
			if(reqUrl.indexOf("?")!=-1){
				urlKey =reqUrl.substring(0,reqUrl.indexOf("?"));
			}else{
				urlKey =reqUrl;
			}
			configAttributes=resourceMap.get(urlKey);
			//公共访问资源,不受菜单制约
			if(configAttributes !=null &&configAttributes.contains(new SecurityConfig("-1"))){
				return null;
			}
		}
		//受菜单制约的访问资源检查
		Iterator<String> it = resourceMap.keySet().iterator();
		while(it.hasNext()){
			String resURL =it.next();
			if(Validator.isNotNullOrEmpty(resURL)){
				
				pathMatcher = new AntPathRequestMatcher(resURL);
				if (pathMatcher.matches(((FilterInvocation) object).getRequest())) {
					Collection<ConfigAttribute> returnCollection = resourceMap
							.get(resURL);
					return returnCollection;
				}
			}
		}
		return null;
		
	}
	


}