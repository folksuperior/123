/**
 * 
 */
package cn.yin.jx.action.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.yin.jx.utils.Encrypt;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月19日
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher{
	/**
	 * Authentication：认证
	 * 重写SimpleCredentialsMatcher类的doCredentialsMatch（密码比较的方法）
	 * 返回true：校验成功
	 * 返回false：校验失败
	 * 
	 * 第一个参数：AuthenticationToken：用户在界面上输入的用户名和密码,思考问题：页面如何传递过来？
	 * 第二个参数：AuthenticationInfo：数据库中用户的密文	 * 
	 */
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		String oldPwd = new String(upToken.getPassword());
		String newPwd = Encrypt.md5(oldPwd, upToken.getUsername());
		Object dbPwd = info.getCredentials();
		
		return equals(newPwd,dbPwd);
	}
	
}
