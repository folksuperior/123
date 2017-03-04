/**
 * 
 */
package cn.yin.jx.action.sysadmin;

import java.util.List;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.common.SysConstant;
import cn.yin.jx.domain.Contract;
import cn.yin.jx.domain.User;
import cn.yin.jx.service.ContractService;
import cn.yin.jx.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ContractAction extends BaseAction implements ModelDriven<Contract>{
	
	private Contract model = new Contract();
	public Contract getModel() {
		return model;
	}
	
	private ContractService contractService;
	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
	
	private Page page = new Page();
	
	
	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public String list(){ 	 	 	
		User user = (User) this.getSession().get(SysConstant.CURRENT_USER_INFO);
		Integer degree = user.getUserInfo().getDegree();
		String hql = "from Contract where 1 = 1";
		if(degree != null && degree == 4){
			//普通员工
			hql += " and createBy = '"+user.getId()+"'";
		}else if(degree == 3){
			//部门经理（管理本部门，不包括下属机构）
			hql += " and createDept = '"+user.getDept().getId()+"'";
		}else if(degree == 2){
			//管理本部门及下属部门
			hql += " and createDept like '"+user.getDept().getId()+"%'";
		}else if(degree == 1){
			//副总(跨部门跨人员)
		}else if( degree == 0){
			//总裁  因为他可以查询所有记录，所以不加条件
		}else{
			//没有等级或者其他等级，待定
		}
		contractService.findPage(hql, page, Contract.class, null);
		page.setUrl("contractAction_list");
		this.push( page);
		/*String contractName = "cargo";
		this.put("contractName", contractName);*/
		return "list";
	}
	
	public String toview(){
		Contract contract = contractService.get(model.getId());
		List<Contract> find = contractService.find("from Contract where id = ?", Contract.class,new String[]{ model.getId()});
		this.push(find.get(0));
		return "toview";
	}
	
	public String tocreate(){
		return "tocreate";
	}
	
	public String insert(){
		User user = (User) this.getSession().get(SysConstant.CURRENT_USER_INFO);
		model.setCreateBy(user.getId());
		model.setCreateDept(user.getDept().getId());
		//设置购销合同的初始总金额 为0
		model.setId(null);
		model.setTotalAmount(0d);
		model.setState(0);//0草稿   1已上报    2已报运
		contractService.save(model);
		return SUCCESS;
	}
	
	public String toupdate(){
		Contract contract = contractService.get(model.getId());
		this.push(contract);
		return "toupdate";
	}
	
	public String update(){
		contractService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String delete(){
		if(model.getId()!= null){
			String[] ids = model.getId().split(", ");
			contractService.delete(ids);
		}
		return SUCCESS;
	}
	
	public String submit(){
		if(model.getId() != null){
			String[] ids = model.getId().split(", ");
			for(String id : ids){
				Contract contract = contractService.get(id);
				contract.setState(1);
				contractService.save(contract);
			}
		}
		return SUCCESS;
	}
	
	public String cancel(){
		if(model.getId() != null){
			String[] ids = model.getId().split(", ");
			for(String id : ids){
				Contract contract = contractService.get(id);
				contract.setState(0);
				contractService.save(contract);
			}
		}
		return SUCCESS;
	}
	
	

}
