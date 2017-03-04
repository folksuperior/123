/**
 * 
 */
package cn.yin.jx.action.sysadmin;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.domain.Module;
import cn.yin.jx.domain.Module;
import cn.yin.jx.service.ModuleService;
import cn.yin.jx.service.ModuleService;
import cn.yin.jx.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ModuleAction extends BaseAction implements ModelDriven<Module>{
	
	private Module model = new Module();
	public Module getModel() {
		return model;
	}
	
	private ModuleService moduleService;
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
	private Page page = new Page();
	
	
	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public String list(){
		String hql = "from Module";
		moduleService.findPage(hql, page, Module.class, null);
		page.setUrl("moduleAction_list");
		this.push( page);
		String moduleName = "sysadmin";
		this.put("moduleName", moduleName);
		return "list";
	}
	
	public String toview(){
		Module module = moduleService.get(model.getId());
		this.push(module);
		return "toview";
	}
	
	public String tocreate(){
		return "tocreate";
	}
	
	public String insert(){
		moduleService.save(model);
		return SUCCESS;
	}
	
	public String toupdate(){
		Module module = moduleService.get(model.getId());
		this.push(module);
		return "toupdate";
	}
	
	public String update(){
		moduleService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String delete(){
		String[] ids = model.getId().split(", ");
		moduleService.delete(ids);
		return SUCCESS;
	}
	
	

}
