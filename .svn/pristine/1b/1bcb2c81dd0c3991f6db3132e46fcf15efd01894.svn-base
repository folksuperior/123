/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.Contract;
import cn.yin.jx.domain.ContractProduct;
import cn.yin.jx.domain.Export;
import cn.yin.jx.domain.ExportProduct;
import cn.yin.jx.domain.ExtCproduct;
import cn.yin.jx.domain.ExtEproduct;
import cn.yin.jx.service.ExportService;
import cn.yin.jx.utils.Page;
import cn.yin.jx.utils.UtilFuns;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ExportServiceImpl implements ExportService{
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<Export> findPage(String hql, Page page, Class<Export> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportService#get(java.lang.String)
	 */
	@Override
	public Export get(String id) {
		return baseDao.get(Export.class, id);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<Export> find(String hql, Class<Export> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportService#save(cn.yin.jx.domain.Export)
	 */
	@Override
	public void save(Export model) {
		String[] contractIds = model.getContractIds().split(", ");
		StringBuffer sb = new StringBuffer();
		for(String id : contractIds){
			Contract contract = baseDao.get(Contract.class, id);
			sb.append(contract.getContractNo()).append(" ");
			contract.setState(2);
			baseDao.saveOrUpdate(contract);
		}
		model.setCustomerContract(sb.toString());
		model.setState(0);
		model.setInputDate(new Date());
		String hql = "from ContractProduct cp where cp.contract.id in("+UtilFuns.joinInStr(contractIds)+")";
		List<ContractProduct> cpList = baseDao.find(hql, ContractProduct.class, null);
		Set<ExportProduct> eps = new HashSet<ExportProduct>();
		for(ContractProduct cp : cpList){
			ExportProduct ep = new ExportProduct();
			//工厂
			ep.setFactory(cp.getFactory());
			//货号
			ep.setProductNo(cp.getProductNo());
			//包装单位
			ep.setPackingUnit(cp.getPackingUnit());
			//数量
			ep.setCnumber(cp.getCnumber());
			//单价
			ep.setPrice(cp.getPrice());
			//排序
			ep.setOrderNo(cp.getOrderNo());
			//附件
			Set<ExtCproduct> extCproducts = cp.getExtCproducts();
			HashSet<ExtEproduct> extEproducts = new HashSet<ExtEproduct>();
			for(ExtCproduct extCproduct : extCproducts){
				ExtEproduct extEproduct = new ExtEproduct();
				BeanUtils.copyProperties(extCproduct, extEproduct);
				extEproduct.setId(null);
				extEproduct.setExportProduct(ep);
				extEproducts.add(extEproduct);
				// 反向关联
				extEproduct.setExportProduct(ep);
			}
			eps.add(ep);
			ep.setExtEproducts(extEproducts);
			// 反向关联
			ep.setExport(model);
			model.setExportProducts(eps);
		}
		baseDao.saveOrUpdate(model);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportService#saveOrUpdate(cn.yin.jx.domain.Export)
	 */
	@Override
	public void saveOrUpdate(Export model) {
			baseDao.saveOrUpdate(model);
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportService#deleteById(java.io.Serializable)
	 */
	@Override
	public void deleteById(Serializable ids) {
		//TODO
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable[] ids) {
		baseDao.delete(Export.class, ids);
	}
	

}
