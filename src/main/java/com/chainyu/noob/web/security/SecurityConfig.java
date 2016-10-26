/**
 * Copyright (c) 2015 Baozun All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Baozun.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Baozun.
 *
 * BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.chainyu.noob.web.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author chainyu_zhang
 * @date 2016年10月23日 下午9:16:15
 */
public class SecurityConfig {
	/**
	 * 忽略的url白名单，支持正则匹配
	 */
	private List<String> whiteList;

	private static List<AntPathRequestMatcher> matcherList = new ArrayList<AntPathRequestMatcher>();
	
	public static Set<String> ignoreParameters = new HashSet<String>(0);

	/**
	 * @return the ignoreParameters
	 */
	public Set<String> getIgnoreParameters() {
		return ignoreParameters;
	}

	/**
	 * @param ignoreParameters the ignoreParameters to set
	 */
	public void setIgnoreParameters(Set<String> ignoreParameters) {
		SecurityConfig.ignoreParameters = ignoreParameters;
	}
	
	public List<String> getWhiteList() {
		return whiteList;
	}
	
	/**
	 * @return the matcherList
	 */
	public static List<AntPathRequestMatcher> getMatcherList() {
		return matcherList;
	}

	public void setWhiteList(List<String> whiteList) {
		this.whiteList = whiteList;
		if (whiteList!=null && !whiteList.isEmpty()) {
			for (String whiteUrl : whiteList) {
				matcherList.add(new AntPathRequestMatcher(whiteUrl));
			}
		}
	}
}
