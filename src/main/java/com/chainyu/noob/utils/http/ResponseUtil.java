package com.chainyu.noob.utils.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import javax.servlet.http.HttpServletResponse;
import com.chainyu.noob.utils.Validator;
import com.chainyu.noob.utils.io.MimeType;


public final class ResponseUtil {

	  /**
     * 以json的方式输出.
     *
     * @param response
     *            HttpServletResponse
     * @param json
     *            json字符串
     * @see #write(HttpServletResponse, Object, String, String)
     * @since 1.0.9
     */
    public static void writeJson(HttpServletResponse response,Object json){
        writeJson(response, json, "UTF-8");
    }
    
    /**
     * 以json的方式输出.
     *
     * @param response
     *            HttpServletResponse
     * @param json
     *            json字符串
     * @param characterEncoding
     *            the character encoding
     * @see #write(HttpServletResponse, Object, String, String)
     * @since 1.0.9
     */
    public static void writeJson(HttpServletResponse response,Object json,String characterEncoding){
        String contentType = MimeType.JSON.getMime() + ";charset=" + characterEncoding;
        write(response, json, contentType, characterEncoding);
    }
    
    /**
     * 输出.
     *
     * @param response
     *            HttpServletResponse
     * @param content
     *            相应内容
     * @throws UncheckedIOException
     *             the unchecked io exception
     * @see javax.servlet.ServletResponse#getWriter()
     * @see java.io.PrintWriter#print(Object)
     * @see java.io.PrintWriter#flush()
     * @see #write(HttpServletResponse, Object, String, String)
     */
    public static void write(HttpServletResponse response,Object content) throws UncheckedIOException{
        String contentType = null;
        String characterEncoding = null;
        write(response, content, contentType, characterEncoding);
    }
    
    /**
     * 输出.
     *
     * @param response
     *            HttpServletResponse
     * @param content
     *            相应内容
     * @param contentType
     *            the content type
     * @param characterEncoding
     *            the character encoding
     * @throws UncheckedIOException
     *             the unchecked io exception
     * @see javax.servlet.ServletResponse#getWriter()
     * @see java.io.PrintWriter#print(Object)
     * @see java.io.PrintWriter#flush()
     * @since 1.0.9
     */
    public static void write(HttpServletResponse response,Object content,String contentType,String characterEncoding)
                    throws UncheckedIOException{
        try{
            //编码 需要在 getWriter之前设置
            if (Validator.isNotNullOrEmpty(contentType)) {
                response.setContentType(contentType);
            }
            if (Validator.isNotNullOrEmpty(characterEncoding)) {
                response.setCharacterEncoding(characterEncoding);
            }

            PrintWriter printWriter = response.getWriter();
            printWriter.print(content);
            printWriter.flush();

            //http://www.iteye.com/problems/56543
            //你是用了tomcat，jetty这样的容器，就不需要 printWriter.close();
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
