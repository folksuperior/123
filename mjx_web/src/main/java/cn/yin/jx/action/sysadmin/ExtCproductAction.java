/**
 * 
 */
package cn.yin.jx.action.sysadmin;

import java.util.List;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.common.SysConstant;
import cn.yin.jx.domain.ExtCproduct;
import cn.yin.jx.domain.Factory;
import cn.yin.jx.domain.User;
import cn.yin.jx.service.ExtCproductService;
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
public class ExtCproductAction extends BaseAction implements ModelDriven<ExtCproduct>{
	
	private ExtCproduct model = new ExtCproduct();
	public ExtCproduct getModel() {
		return model;
	}
	
	private ExtCproductService extCproductService;
	public void setExtCproductService(ExtCproductService extCproductService) {
		this.extCproductService = extCproductService;
	}
	
	private Page page = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public FactoryService factoryService;
	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
		
	}
	
	public String list(){
		String hql = "from ExtCproduct";
		extCproductService.findPage(hql, page, ExtCproduct.class, null);
		page.setUrl("extCproductAction_list");
		this.push( page);
		String extCproductName = "sysadmin";
		this.put("extCproductName", extCproductName);
		return "list";
	}
	
	public String toview(){
		ExtCproduct extCproduct = extCproductService.get(model.getId());
		this.push(extCproduct);
		return "toview";
	}
	
	// 查看附件
	public String tocreate(){
		List<Factory> factoryList = factoryService.find("from Factory", Factory.class, null);
		this.put("factoryList", factoryList);
		extCproductService.findPage("from ExtCproduct where contractProduct.id = ?", page, ExtCproduct.class, new String[]{model.getContractProduct().getId()});
		page.setUrl("extCproductAction_tocreate");
		this.push(page);
		return "tocreate";
	}
	
	// 添加附件 
	public String insert(){
		extCproductService.save(model);
		return this.tocreate();
	}
	
	public String toupdate(){
		ExtCproduct extCproduct = extCproductService.get(model.getId());
		this.push(extCproduct);
		List<Factory> factoryList = factoryService.find("from Factory", Factory.class, null);
		this.put("factoryList", factoryList);
		return "toupdate";
	}
	
	public String update(){
		ExtCproduct extCproduct = extCproductService.get(model.getId());
		// 页面修改的属性，就要更新值
		model.setFactory(model.getFactory());
		model.setFactoryName(model.getFactoryName());
		model.setProductNo(model.getProductNo());
		model.setProductImage(model.getProductImage());
		model.setCnumber(model.getCnumber());
		model.setPackingUnit(model.getPackingUnit());
		model.setPrice(model.getPrice());
		model.setOrderNo(model.getOrderNo());
		model.setProductDesc(model.getProductDesc());
		model.setProductRequest(model.getProductRequest());
		extCproductService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String delete(){
		extCproductService.delete(ExtCproduct.class,model);
		return SUCCESS;
	}
	
	

}
