package com.chainyu.noob.web.security;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

/**
 * @author chainyu_zhang
 * @date 2016年11月7日 下午10:34:08
 */
public class SecurityWrapperMultipartRequest extends SecurityWrapperRequest implements MultipartHttpServletRequest {

	public SecurityWrapperMultipartRequest(HttpServletRequest request) {
		super(request);
	}
	
	private MultipartHttpServletRequest getMultipartHttpServletRequest() {
		return WebUtils.getNativeRequest(this.getRequest(), MultipartHttpServletRequest.class);
		
	}
	public Iterator<String> getFileNames() {
		return this.getMultipartHttpServletRequest().getFileNames();
	}

	public MultipartFile getFile(String name) {
		return this.getMultipartHttpServletRequest().getFile(name);
	}

	public List<MultipartFile> getFiles(String name) {
		return this.getMultipartHttpServletRequest().getFiles(name);
	}

	public Map<String, MultipartFile> getFileMap() {
		return this.getMultipartHttpServletRequest().getFileMap();
	}

	public MultiValueMap<String, MultipartFile> getMultiFileMap() {
		return this.getMultipartHttpServletRequest().getMultiFileMap();
	}

	public String getMultipartContentType(String paramOrFileName) {
		return this.getMultipartHttpServletRequest().getMultipartContentType(paramOrFileName);
	}

	public HttpMethod getRequestMethod() {
		return this.getMultipartHttpServletRequest().getRequestMethod();
	}

	public HttpHeaders getRequestHeaders() {
		return this.getMultipartHttpServletRequest().getRequestHeaders();
	}

	public HttpHeaders getMultipartHeaders(String paramOrFileName) {
		return this.getMultipartHttpServletRequest().getMultipartHeaders(paramOrFileName);
	}
}
