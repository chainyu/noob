package com.chainyu.noob.web.security;

import org.owasp.esapi.codecs.MySQLCodec;
import org.owasp.esapi.codecs.MySQLCodec.Mode;

/**
 * @author chainyu_zhang
 * @date 2016年10月23日 下午9:25:46
 */
public class SQLInjectionEncodeSecurityActivity implements SecurityActivity {
	MySQLCodec codec = new MySQLCodec(Mode.ANSI);
	private final static char[] IMMUNE_SQL = { ' ' };
	
	@Override
	public String execute(String value) {
		return value == null ? "" : codec.encode(IMMUNE_SQL, value);
	}

}
