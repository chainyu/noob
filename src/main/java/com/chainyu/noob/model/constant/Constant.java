package com.chainyu.noob.model.constant;


/**
 * 常量类
 * @author chainyu_zhang
 * @date 2016年11月1日 下午10:06:31
 */
public class Constant {
	
	
	
	/************************系统级别自定义名称 跟 url***************************/
	/****首页名称******/
	public static final String          SYSTEM_CUSTOM_INDEX_NAME           ="首页";
	/****首页url*********/
	public static final String          SYSTEM_CUSTOM_INDEX_URL            ="index";
	/****退换货政策名称******/
	public static final String          SYSTEM_CUSTOM_RETURN_POLICY_NAME   ="退换货政策";
	/****退换货政策url*********/
	public static final String          SYSTEM_CUSTOM_RETURN_POLICY_URL    ="returnpolicy";
	/***登录用户的 用户名称参数 (j_username)*****/
	public static final String          USER_LOGIN_NAME_PARAMETER 		   = "j_username";
	
	/***用户登录失败后锁定的时间 ： 24h 86400000 单位毫秒 ***/
	public static final long            USER_LOGIN_FAIL_LOCKED_TIME        = 86400000;
	/***允许用户连续登录失败的时间段 ：24h 单位毫秒***/
	public static final long            ALLOW_USER_UNINTERRUPTE_LOGIN_TIME = 86400000;
	/***允许用户在一段时间内连续登录失败的次数***/
	public static final long            ALLOW_USER_LOGIN_FAIL_FREQUENCY    = 6 ;
	/****重置密码url*********/
	public static final String          SYSTEM_CUSTOM_RESET_PASSWORD_URL   ="/reset.htm";
	/*****时间戳加密密钥*******************/
	public static final String          TIMESTAMP_ENCRYPTION_KEY           ="ObT0m5cFp69XaFiBuRtTDQ==";
	

    /** GBK可以表示简体中文和繁体中文 <code>{@value}</code>. */
    public static final String GBK        = "GBK";

    /** GB2312只能表示简体中文 <code>{@value}</code>. */
    public static final String GB2312     = "GB2312";

    /** <code>{@value}</code>. */
    public static final String GB18030    = "GB18030";

    // *********************************************************************************************
    /** <code>{@value}</code>. */
    public static final String UTF8       = "UTF-8";

    /**
     * <code>{@value}</code>
     * <p>
     * ISO Latin Alphabet #1, also known as ISO-LATIN-1.<br>
     * Every implementation of the Java platform is required to support this character encoding.
     * </p>
     * 　ISO/IEC 8859-1，又称Latin-1或“西欧语言”，是国际标准化组织内ISO/IEC 8859的第一个8位字符集.<br>
     * 它以ASCII为基础，在空置的0xA0-0xFF的范围内，加入192个字母及符号，藉以供使用变音符号的拉丁字母语言使用.<br>
     * 此字符集支援部分于欧洲使用的语言，包括阿尔巴尼亚语、巴斯克语、布列塔尼语、加泰罗尼亚语、丹麦语、荷兰语、法罗语、弗里西语、加利西亚语、德语、格陵兰语、冰岛语、爱尔兰盖尔语、意大利语、拉丁语、卢森堡语、挪威语、葡萄牙语、里托罗曼斯语、苏格兰盖尔语、西班牙语及瑞典语.
     * 　<br>
     * 　英语虽然没有重音字母，但仍会标明为ISO 8859-1编码.除此之外，欧洲以外的部分语言，如南非荷兰语、斯瓦希里语、印尼语及马来语、菲律宾他加洛语等也可使用ISO 8859-1编码. 　　<br>
     * 法语及芬兰语本来也使用ISO 8859-1来表示.但因它没有法语使用的 œ、Œ、 Ÿ 三个字母及芬兰语使用的 Š、š、Ž、ž ，故于1998年被ISO/IEC 8859-15所取代.（ISO 8859-15同时加入了欧元符号）
     */
    public static final String ISO_8859_1 = "ISO-8859-1";
	
}
