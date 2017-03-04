/**
 * 
 */
package cn.yin.jx.action.cargo;

import java.util.HashSet;
import java.util.Set;

import cn.yin.jx.action.BaseAction;
import cn.yin.jx.domain.Contract;
import cn.yin.jx.domain.Export;
import cn.yin.jx.domain.ExportProduct;
import cn.yin.jx.service.ContractService;
import cn.yin.jx.service.ExportProductService;
import cn.yin.jx.service.ExportService;
import cn.yin.jx.utils.Page;
import cn.yin.jx.utils.UtilFuns;

import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ExportAction extends BaseAction implements ModelDriven<Export>{
	private String[] mr_id;//id
	private Integer[] mr_changed;//是否改变了
	private Integer[] mr_cnumber;//数量
	private Double[] mr_grossWeight;//毛重
	private Double[] mr_netWeight;//净重
	private Double[] mr_sizeLength;//长
	private Double[] mr_sizeWidth;//宽
	private Double[] mr_sizeHeight;//高
	private Double[] mr_exPrice;//单价
	private Double[] mr_tax;//税	
	
	public String[] getMr_id() {
		return mr_id;
	}
	public void setMr_id(String[] mr_id) {
		this.mr_id = mr_id;
	}
	public Integer[] getMr_changed() {
		return mr_changed;
	}
	public void setMr_changed(Integer[] mr_changed) {
		this.mr_changed = mr_changed;
	}
	public Integer[] getMr_cnumber() {
		return mr_cnumber;
	}
	public void setMr_cnumber(Integer[] mr_cnumber) {
		this.mr_cnumber = mr_cnumber;
	}
	public Double[] getMr_grossWeight() {
		return mr_grossWeight;
	}
	public void setMr_grossWeight(Double[] mr_grossWeight) {
		this.mr_grossWeight = mr_grossWeight;
	}
	public Double[] getMr_netWeight() {
		return mr_netWeight;
	}
	public void setMr_netWeight(Double[] mr_netWeight) {
		this.mr_netWeight = mr_netWeight;
	}
	public Double[] getMr_sizeLength() {
		return mr_sizeLength;
	}
	public void setMr_sizeLength(Double[] mr_sizeLength) {
		this.mr_sizeLength = mr_sizeLength;
	}
	public Double[] getMr_sizeWidth() {
		return mr_sizeWidth;
	}
	public void setMr_sizeWidth(Double[] mr_sizeWidth) {
		this.mr_sizeWidth = mr_sizeWidth;
	}
	public Double[] getMr_sizeHeight() {
		return mr_sizeHeight;
	}
	public void setMr_sizeHeight(Double[] mr_sizeHeight) {
		this.mr_sizeHeight = mr_sizeHeight;
	}
	public Double[] getMr_exPrice() {
		return mr_exPrice;
	}
	public void setMr_exPrice(Double[] mr_exPrice) {
		this.mr_exPrice = mr_exPrice;
	}
	public Double[] getMr_tax() {
		return mr_tax;
	}
	public void setMr_tax(Double[] mr_tax) {
		this.mr_tax = mr_tax;
	}

	private Export model = new Export();
	public Export getModel() {
		return model;
	}
	
	private ExportService exportService;
	public void setExportService(ExportService exportService) {
		this.exportService = exportService;
	}
	
	private ExportProductService exportProductService;
	public void setExportProductService(ExportProductService exportProductService) {
		this.exportProductService = exportProductService;
	}
	
	private Page page = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	private ContractService contractService;
	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
	public String contractList(){
		contractService.findPage("from Contract", page, Contract.class, null);
		page.setUrl("exportAction_contractList");
		this.push(page);
		
		return "contractList";
	}

	public String list(){
		String hql = "from Export";
		//exportService.
		exportService.findPage(hql, page, Export.class, null);
		page.setUrl("exportAction_list");
		this.push( page);
		/*String exportName = "cargo";
		this.put("exportName", exportName);*/
		return "list";
	}
	
	public String toview(){
		Export export = exportService.get(model.getId());
		this.push(export);
		return "toview";
	}
	
	public String tocreate(){
		return "tocreate";
	}
	
	public String insert(){
		
		exportService.save(model);
		return SUCCESS;
	}
	
	/**
	 * 	在进入update.jsp页面之前，将货物的信息组装好(暂时先不考虑附件)
	 * 	addTRRecord("mRecordTable", "id", "productNo", "cnumber",
	 *  "grossWeight", "netWeight", "sizeLength", "sizeWidth", "sizeHeight", "exPrice", "tax");
	 */
	public String toupdate(){
		Export export = exportService.get(model.getId());
		this.push(export);
		
		Set<ExportProduct> eps = export.getExportProducts();
		StringBuffer sb = new StringBuffer();
		for(ExportProduct ep : eps){
			sb.append("addTRRecord('mRecordTable'");
			sb.append(",'"+ep.getId()+"'");
			sb.append(",'"+ep.getProductNo()+"'");
			sb.append(",'"+ep.getCnumber()+"'");
			sb.append(",'"+(ep.getGrossWeight()==null?"":ep.getGrossWeight())+"'");
			sb.append(",'"+UtilFuns.convertNull(ep.getNetWeight())+"'");
			sb.append(",'"+UtilFuns.convertNull(ep.getSizeLength())+"'");
			sb.append(",'"+UtilFuns.convertNull(ep.getSizeWidth())+"'");
			sb.append(",'"+UtilFuns.convertNull(ep.getSizeHeight())+"'");
			sb.append(",'"+UtilFuns.convertNull(ep.getExPrice())+"'");
			sb.append(",'"+UtilFuns.convertNull(ep.getTax())+"');");
		}
		this.put("mRecordData", sb.toString());
		return "toupdate";
	}
	
	public String update(){
		Export export = exportService.get(model.getId());
		//报运号
		export.setCustomerContract(model.getCustomerContract());
		//制单日期
		export.setInputDate(model.getInputDate());
		//信用证号
		export.setLcno(model.getLcno());
		//收货人及地址
		export.setConsignee(model.getConsignee());
		//装运港
		export.setShipmentPort(model.getShipmentPort());
		//目的港
		export.setDestinationPort(model.getDestinationPort());
		//运输方式
		export.setTransportMode(model.getTransportMode());
		//价格条件
		export.setPriceCondition(model.getPriceCondition());
		//唛头
		export.setMarks(model.getMarks());
		//备注
		export.setRemark(model.getRemark());
		
		HashSet<ExportProduct> epSet = new HashSet<ExportProduct>();
		for(int i = 0; i < mr_id.length; i ++){
			ExportProduct ep = exportProductService.get(mr_id[i]);
			if(mr_changed[i] != null&& mr_changed[i] == 1 ){
				ep.setCnumber(mr_cnumber[i]);
				ep.setGrossWeight(mr_grossWeight[i]);
				ep.setNetWeight(mr_netWeight[i]);
				ep.setSizeLength(mr_sizeLength[i]);
				ep.setSizeWidth(mr_sizeWidth[i]);
				ep.setSizeHeight(mr_sizeHeight[i]); 
				ep.setExPrice(mr_exPrice[i]);	
				ep.setTax(mr_tax[i]);
			}
			epSet.add(ep);
		}
		export.setExportProducts(epSet);
		exportService.saveOrUpdate(export);
		return SUCCESS;
	}
	
	public String submit(){
		String[] ids = model.getId().split(", ");
		for(String id : ids){
			Export export = exportService.get(id);
			export.setState(1);
			exportService.saveOrUpdate(export);
		}
		return list();
	}
	
	public String cancel(){
		String[] ids = model.getId().split(", ");
		for(String id : ids){
			Export export = exportService.get(id);
			export.setState(0);
			exportService.saveOrUpdate(export);
		}
		return list();
	}
	
	public String delete(){
		String[] ids = model.getId().split(", ");
		exportService.delete(ids);
		return SUCCESS;
	}
	
	

}
