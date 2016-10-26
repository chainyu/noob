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
