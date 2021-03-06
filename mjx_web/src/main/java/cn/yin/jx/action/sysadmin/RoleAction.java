/**
 * 
 */
package cn.yin.jx.action.sysadmin;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.domain.Module;
import cn.yin.jx.domain.Role;
import cn.yin.jx.service.ModuleService;
import cn.yin.jx.service.RoleService;
import cn.yin.jx.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class RoleAction extends BaseAction implements ModelDriven<Role>{
	
	private Role model = new Role();
	public Role getModel() {
		return model;
	}
	
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	private Page page = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public ModuleService moduleService;
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
	public String moduleIds;
	public String getModuleIds() {
		return moduleIds;
	}
	public void setModuleIds(String moduleIds) {
		this.moduleIds = moduleIds;
	}
	
	public String list(){
		String hql = "from Role";
		roleService.findPage(hql, page, Role.class, null);
		page.setUrl("roleAction_list");
		this.push( page);
		String moduleName = "sysadmin";
		this.put("moduleName", moduleName);
		return "list";
	}
	
	public String toview(){
		Role role = roleService.get(model.getId());
		this.push(role);
		return "toview";
	}
	
	public String tocreate(){
		return "tocreate";
	}
	
	public String insert(){
		roleService.save(model);
		return SUCCESS;
	}
	
	public String toupdate(){
		Role role = roleService.get(model.getId());
		this.push(role);
		return "toupdate";
	}
	
	public String update(){
		roleService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String delete(){
		String[] ids = model.getId().split(", ");
		roleService.delete(ids);
		return SUCCESS;
	}
	
	public String tomodule(){
		Role role = roleService.get(model.getId());
		this.push(role);
		return "tomodule";
	}
	//Json的格式如下：
	/*[
	{id:"1",pId:"0",name:"部门管理",checked:"true|false"},
	{id:"1",pId:"0",name:"部门管理",checked:"true|false"}
	]*/
	
	public String roleModuleJsonStr() throws IOException{
		List<Module> moduleList = moduleService.find("from Module", Module.class, null);
		Role role = roleService.get(model.getId());
		Set<Module> modules = role.getModules();
		String str = "[";
		for(Module module : moduleList){
			String flag;
			if(modules.contains(module)){
				flag = "true";
			}else{
				flag = "false";
			}
			str += "{id:'"+module.getId()+"',pId:'"+module.getParentId()+"',name:'"+
					module.getName()+"',checked:'"+flag+"'},";
			
		}
		str = str.substring(0,str.length() - 1);
		str += "]";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8"); 
		response.setHeader("cache-control","no-cache");
		response.getWriter().write(str);
		
		return NONE;
	}
	
	public String module(){
		String[] mIds = moduleIds.split(",");
		Set<Module> modules = new HashSet<Module>();
		for(String mId : mIds){
			Module module = moduleService.get(mId);
			modules.add(module);
		}
		Role role = roleService.get(model.getId());
		role.setModules(modules);
		roleService.save(role);
		return SUCCESS;
	}
	
	

}
