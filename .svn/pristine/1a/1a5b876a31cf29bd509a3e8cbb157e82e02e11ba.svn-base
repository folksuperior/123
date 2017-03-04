/**
 * 
 */
package cn.yin.jx.action.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.yin.jx.domain.Module;
import cn.yin.jx.domain.Role;
import cn.yin.jx.domain.User;
import cn.yin.jx.service.UserService;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月19日
 */
public class AuthRealm extends AuthorizingRealm{
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 认证  登录
	 * 当用户登录的时候，shiro真正会调用它，来实现登录操作
	 * 
	 * 当这个方法返回null时，就会出现异常
	 * 当认证成功后，返回的对象不为null时，就会自动进入密码比较器（在shiro的xml文件中，配置了密码比较器）
	 * 	<property name="credentialsMatcher" ref="passwordMatcher"/>
	 * 
	 * 第一个参数：AuthenticationToken token：用户在页面输入的用户名和密码
	 * 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 授权
		User user = (User) principals.fromRealm(this.getName()).iterator().next();
		
		Set<Role> roles = user.getRoles();
		
		List<String> list = new ArrayList();
		
		for(Role role : roles){
			Set<Module> modules = role.getModules();
			
			for(Module module : modules){
				if(module.getCtype() == 0){
					list.add(module.getCpermission());
				}
			}
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(list);
		
		return info;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//认证
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		
		User user = userService.findUserByName(upToken.getUsername());
		
		if(user == null){
			return null;
		}
		AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		return info;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
