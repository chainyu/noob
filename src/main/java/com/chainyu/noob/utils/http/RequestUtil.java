package com.chainyu.noob.utils.http;

import javax.servlet.http.HttpServletRequest;

import com.chainyu.noob.utils.Validator;
import com.chainyu.noob.utils.http.entity.HttpHeaders;

public final class RequestUtil {

	/**
     * 判断一个请求是否是ajax请求.<br>
     * 注:x-requested-with这个头是某些JS类库给加上去的，直接写AJAX是没有这个头的,<br>
     * jquery/ext 确定添加,暂时可以使用这个来判断<br>
     * 
     * <p>
     * The X-Requested-With is a non-standard HTTP header which is mainly used to identify Ajax requests. <br>
     * Most JavaScript frameworks send this header with value of XMLHttpRequest.
     * </p>
     * 
     * @param request
     *            the request
     * @return 如果是ajax 请求 返回true
     * @see "http://en.wikipedia.org/wiki/X-Requested-With#Requested-With"
     */
    public static final boolean isAjaxRequest(HttpServletRequest request){
        String header = request.getHeader(HttpHeaders.X_REQUESTED_WITH);
        if (Validator.isNotNullOrEmpty(header) && header.equalsIgnoreCase(HttpHeaders.X_REQUESTED_WITH_VALUE_AJAX)) {
            return true;
        }
        return false;
    }
}
