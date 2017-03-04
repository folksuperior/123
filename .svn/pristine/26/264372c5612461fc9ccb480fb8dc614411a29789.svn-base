/**
 * 
 */
package cn.yin.jx.action.sysadmin;

import java.util.List;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.domain.ContractProduct;
import cn.yin.jx.domain.Factory;
import cn.yin.jx.service.ContractProductService;
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
public class ContractProductAction extends BaseAction implements ModelDriven<ContractProduct>{
	
	private ContractProduct model = new ContractProduct();
	public ContractProduct getModel() {
		return model;
	}
	
	private FactoryService factoryService;
	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
	}

	private ContractProductService contractProductService;
	public void setContractProductService(ContractProductService contractProductService) {
		this.contractProductService = contractProductService;
	}
	
	private Page page = new Page();
	
	
	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public String list(){
		String hql = "from ContractProduct";
		contractProductService.findPage(hql, page, ContractProduct.class, null);
		page.setUrl("contractProductServiceAction_list");
		this.push( page);
		return "list";
	}
	
	public String toview(){
		ContractProduct contractProduct = contractProductService.get(model.getId());
		this.push(contractProduct);
		return "toview";
	}
	
	public String tocreate(){
		List<Factory> factoryList = factoryService.find("from Factory where state = 1 and ctype = '货物'", Factory.class, null);
		this.put("factoryList", factoryList);
		
		contractProductService.findPage("from ContractProduct where contract.id = ?", page, ContractProduct.class, new Object[]{model.getContract().getId()});
		page.setUrl("contractProductAction_tocreate");
		this.push(page);
		return "tocreate";
	}
	
	public String insert(){
		contractProductService.save(model);
		return this.tocreate();
	}
	
	public String toupdate(){
		ContractProduct contractProduct = contractProductService.get(model.getId());
		this.push(contractProduct);
		//2.加载生产厂家
		List<Factory> factoryList = factoryService.find("from Factory where state=1 and ctype='货物'", Factory.class,null);
		super.put("factoryList", factoryList);
		return "toupdate";
	}
	
	public String update(){
		contractProductService.saveOrUpdate(model);
		return this.tocreate();
	}
	
	public String delete(){
		String[] ids = model.getId().split(", ");
		contractProductService.delete(ids);
		return this.tocreate();
	}
	
	

}
