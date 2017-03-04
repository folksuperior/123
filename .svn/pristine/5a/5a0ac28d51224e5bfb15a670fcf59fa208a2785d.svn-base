/**
 * 
 */
package cn.yin.jx.action.sysadmin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.domain.Dept;
import cn.yin.jx.domain.Role;
import cn.yin.jx.domain.User;
import cn.yin.jx.service.DeptService;
import cn.yin.jx.service.RoleService;
import cn.yin.jx.service.UserService;
import cn.yin.jx.utils.Page;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description:
 * @author: 尹成功
 * @version: 1.0
 * @Company: http://java.itcast.cn
 * @date: 2017年2月18日
 */
public class UserAction extends BaseAction implements ModelDriven<User> {

	private User model = new User();
	public User getModel() {
		return model;
	}

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	private String roleIds;
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	private Page page = new Page();

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String list() {
		String hql = "from User";
		userService.findPage(hql, page, User.class, null);
		page.setUrl("userAction_list");
		this.push(page);
		String moduleName = "sysadmin";
		this.put("moduleName", moduleName);
		return "list";
	}

	public String toview() {
		String hql = "from User where id = ?";
		User user = userService.get(model.getId());
		this.push(user);
		return "toview";
	}

	public String tocreate() {
		// 所属部门
		String hql = "from Dept where state = 1";
		List<Dept> deptList = deptService.find(hql, Dept.class, null);
		
		// 直属领导
		List<User> userList = userService.find("from User where state = 1", User.class, null);
		
		this.put("deptList", deptList);
		this.put("userList", userList);
		return "tocreate";
	}
	
	public String insert(){
		userService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String toupdate(){
		String hql = "from Dept where state = 1";
		List<Dept> deptList = deptService.find(hql, Dept.class, null);
		
		User user = userService.get(model.getId());
		
		this.put("deptList", deptList);
		this.push(user);
		
		
		return "toupdate";
	}
	
	public String update(){
		userService.saveOrUpdate(model);
		return list();
	}
	
	public String delete(){
		String[] ids = model.getId().split(", ");
		userService.delete(ids);
		return SUCCESS;
	}
	
	public String torole(){
		User user = userService.get(model.getId());
		
		Set<Role> roles = user.getRoles();
		StringBuffer sb = new StringBuffer();
		for(Role role : roles){
			sb.append(role.getName()).append(",");
			
		}
		
		List<Role> roleList = roleService.find("from Role", Role.class, null);
		
		this.push(user);
		this.put("userRoleStr",sb.toString());
		this.put("roleList", roleList);
		return "torole";
	}
	
	public String role(){
		User user = userService.get(model.getId());
		String[] rIds = roleIds.split(", ");
		Set<Role> roles = new HashSet<Role>();
		for(String rId : rIds){
			Role role = roleService.get(rId);
			roles.add(role);
		}
		user.setRoles(roles);
		userService.save(user);
		return SUCCESS;
	} 

}
