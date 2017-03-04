/**
 * 
 */
package cn.yin.jx.action.cargo;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.domain.ExtEproduct;
import cn.yin.jx.domain.ExtEproduct;
import cn.yin.jx.service.ExtEproductService;
import cn.yin.jx.service.ExtEproductService;
import cn.yin.jx.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ExtEproductAction extends BaseAction implements ModelDriven<ExtEproduct>{
	
	private ExtEproduct model = new ExtEproduct();
	public ExtEproduct getModel() {
		return model;
	}
	
	private ExtEproductService extEproductService;
	public void setExtEproductService(ExtEproductService extEproductService) {
		this.extEproductService = extEproductService;
	}
	
	private Page page = new Page();
	
	
	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public String list(){
		String hql = "from ExtEproduct";
		extEproductService.findPage(hql, page, ExtEproduct.class, null);
		page.setUrl("extEproductAction_list");
		this.push( page);
		String extEproductName = "sysadmin";
		this.put("extEproductName", extEproductName);
		return "list";
	}
	
	public String toview(){
		ExtEproduct extEproduct = extEproductService.get(model.getId());
		this.push(extEproduct);
		return "toview";
	}
	
	public String tocreate(){
		return "tocreate";
	}
	
	public String insert(){
		extEproductService.save(model);
		return SUCCESS;
	}
	
	public String toupdate(){
		ExtEproduct extEproduct = extEproductService.get(model.getId());
		this.push(extEproduct);
		return "toupdate";
	}
	
	public String update(){
		extEproductService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String delete(){
		String[] ids = model.getId().split(", ");
		extEproductService.delete(ids);
		return SUCCESS;
	}
	
	

}
