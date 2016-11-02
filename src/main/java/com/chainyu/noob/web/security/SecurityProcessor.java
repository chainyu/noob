package com.chainyu.noob.web.security;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author chainyu_zhang
 * @date 2016年10月23日 下午9:16:58
 */
public class SecurityProcessor {
	private static List<SecurityActivity> activities = new ArrayList<SecurityActivity>();
	private static final Logger LOGGER = Logger.getLogger(SecurityProcessor.class);
	static {
		activities.add(new SQLInjectionEncodeSecurityActivity());
		activities.add(new HtmlEscapeSecurityActivity());
	}

	public static String process(HttpServletRequest request, String name, String value) {
		if(!needProcess(request, name)) {
			return value;
		}
		String result = value;
		for (Iterator<SecurityActivity> iterator = activities.iterator(); iterator.hasNext();) {
			SecurityActivity securityActivity = iterator.next();
			result = securityActivity.execute(result);
		}
		LOGGER.debug(String.format("original data: [%s] new data: [%s]", value, result));
		return result;
	}
	
	private static boolean needProcess(HttpServletRequest request, String name) {
		List<AntPathRequestMatcher> matcherList = SecurityConfig.getMatcherList();
		if (!matcherList.isEmpty()) {
			for (AntPathRequestMatcher matcher : matcherList) {
				if (matcher.matches(request)) {
					return false;
				}
			}
		}
		return !SecurityConfig.ignoreParameters.contains(name);
	}
}
