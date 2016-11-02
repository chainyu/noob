package com.chainyu.noob.web.security;

import org.springframework.web.util.HtmlUtils;

/**
 * @author chainyu_zhang
 * @date 2016年10月23日 下午9:15:27
 */
public class HtmlEscapeSecurityActivity implements SecurityActivity {
	
	@Override
	public String execute(String value) {
		return value == null ? "" : HtmlUtils.htmlEscape(value);
	}
}
