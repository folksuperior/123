/**
 * 
 */
package cn.yin.jx.action.sysadmin;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.domain.Dept;
import cn.yin.jx.service.DeptService;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月15日
 */
public class DeptAction extends BaseAction implements ModelDriven<Dept>{
	
	private Dept model = new Dept();
	
	public Dept getModel() {
		return model;
	}

	

	// 注入DeptService
	private DeptService deptService;

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	// 分页组件
	private Page page= new Page();

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	// 分页查询
	public String list(){
		String hql = "from Dept";
		deptService.findPage(hql, page, Dept.class, null);
		
		page.setUrl("deptAction_list");// 相对定位
		
		ActionContext.getContext().getValueStack().push(page);
		String moduleName = "sysadmin";
		this.put("moduleName", moduleName);
		
		return "list";
		
	}
	
	public String toview() {
		
		Dept dept = deptService.get(model.getId());
		this.push(dept);
		return "toview";
	}
	
	public String tocreate(){
		String hql = "from Dept";
		List<Dept> deptList = deptService.find(hql, Dept.class, null);
		this.put("deptList", deptList);
		return "tocreate";
	}
	
	public String insert(){
		deptService.save(model);
		return SUCCESS;
	}
	
	public String toupdate(){
		String hql = "from Dept where state = 1";
		List<Dept> deptList = deptService.find(hql, Dept.class, null);
		Dept dept = deptService.get(model.getId());
		deptList.remove(dept);
		this.put("deptList", deptList);
		this.push(dept);
		return "toupdate";
	}
	
	public String update(){
		deptService.saveOrUpdate(model);
		return SUCCESS;
	}
	
	public String delete(){
		String[] ids = model.getId().split(", ");
		deptService.delete(ids);
		return SUCCESS;
	}

}
