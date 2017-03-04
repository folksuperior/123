/**
 * 
 */
package cn.yin.jx.action.sysadmin;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.domain.Factory;
import cn.yin.jx.domain.Factory;
import cn.yin.jx.service.FactoryService;
import cn.yin.jx.service.FactoryService;
import cn.yin.jx.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class FactoryAction extends BaseAction implements ModelDriven<Factory>{
	
	private Factory model = new Factory();
	public Factory getModel() {
		return model;
	}
	
	private FactoryService factoryService;
	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
	}
	
	private Page page = new Page();
	
	
	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public String list(){
		String hql = "from Factory";
		factoryService.findPage(hql, page, Factory.class, null);
		page.setUrl("factoryAction_list");
		this.push( page);
		String factoryName = "sysadmin";
		this.put("factoryName", factoryName);
		return "list";
	}
	
	public String toview(){
		Factory factory = factoryService.get(model.getId());
		this.push(factory);
		return "toview";
	}
	
	public String tocreate(){
		return "tocreate";
	}
	
	public String insert(){
		factoryService.save(model);
		return SUCCESS;
	}
	
	public String toupdate(){
		Factory factory = factoryService.get(model.getId());
		this.push(factory);
		return "toupdate";
	}
	
	public String update(){
		factoryService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String delete(){
		String[] ids = model.getId().split(", ");
		factoryService.delete(ids);
		return SUCCESS;
	}
	
	

}
