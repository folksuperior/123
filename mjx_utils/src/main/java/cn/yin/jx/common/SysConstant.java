package cn.yin.jx.common;

import org.apache.log4j.Logger;

/**
 * @Description:
 * @Author:		传智播客 java学院	传智.袁新奇
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月31日
 */
/*
 * 系统全局常量配置类
 */
public class SysConstant {
	private static Logger log = Logger.getLogger(SysConstant.class);

	public static String CURRENT_USER_INFO = "_CURRENT_USER";	//当前用户session name
	public static String USE_DATABASE = "MySql";				//使用的数据库 Oracle/SQLServer
	public static String USE_DATABASE_VER = "5.0";				//使用的数据库版本 10g/2000

	public static String DEFAULT_PASS = "123456";				//默认密码
	public static int PAGE_SIZE = 3;							//分页时一页显示多少条记录
	
	public static int Enable = 1;								//部门状态启用
	public static int Disable = 0;								//部门状态禁用
}