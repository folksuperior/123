/**
 * 
 */
package cn.yin.jx.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class User extends BaseEntity{
	//用户编号
		private String id;
		//部门编号
		//用户与部门，是多对一的关系
		private Dept dept;
		
		//用户姓名
		private String userName;
		//密码 
		private String password;
		//状态 0 禁用 1 启用
		private Integer state;
		
		//用户扩展信息
		private UserInfo userInfo;
		
		private Set<Role> roles = new HashSet();
		public Set<Role> getRoles() {
			return roles;
		}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Dept getDept() {
			return dept;
		}

		public void setDept(Dept dept) {
			this.dept = dept;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Integer getState() {
			return state;
		}

		public void setState(Integer state) {
			this.state = state;
		}

		public UserInfo getUserInfo() {
			return userInfo;
		}

		public void setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
		}
		
		

}
