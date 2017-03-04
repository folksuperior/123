/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.Contract;
import cn.yin.jx.domain.ContractProduct;
import cn.yin.jx.service.ContractService;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ContractServiceImpl implements ContractService{
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<Contract> findPage(String hql, Page page, Class<Contract> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractService#get(java.lang.String)
	 */
	@Override
	public Contract get(String id) {
		Contract contract = baseDao.get(Contract.class, id);
		String crequest = contract.getCrequest();
		if(crequest != null && !"".equals(crequest)){
			contract.setCrequest(crequest.replaceAll("\\\\r\\\\n", "<br>"));
		}
		String loadingRate = "";
		Set<ContractProduct> newContractProducts = new HashSet<ContractProduct>();
		Set<ContractProduct> contractProducts = contract.getContractProducts();
		for(ContractProduct cp : contractProducts){
			if(cp.getLoadingRate()!= null){
				loadingRate = cp.getLoadingRate();
				loadingRate = loadingRate.replaceAll("\\\\r\\\\n", "<br>");
				cp.setLoadingRate(loadingRate);
			}
			newContractProducts.add(cp);
		}
		contract.setContractProducts(newContractProducts);
		return contract;
	}
	

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<Contract> find(String hql, Class<Contract> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractService#save(cn.yin.jx.domain.Contract)
	 */
	@Override
	public void save(Contract model) {
		baseDao.saveOrUpdate(model);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractService#saveOrUpdate(cn.yin.jx.domain.Contract)
	 */
	@Override
	public void saveOrUpdate(Contract model) {
		Contract contract = baseDao.get(Contract.class, model.getId());
		//设置属性
		//客户名称
		contract.setCustomName(model.getCustomName());
		//合同号
		contract.setContractNo(model.getContractNo());
		//制单人,就是签单人
		contract.setInputBy(model.getInputBy());
		//验货员
		contract.setInspector(model.getInspector());
		//重要程度
		contract.setImportNum(model.getImportNum());
		//贸易条款
		contract.setTradeTerms(model.getTradeTerms());
		//要求
		contract.setCrequest(model.getCrequest());
		//打印板式
		contract.setPrintStyle(model.getPrintStyle());
		//收购方
		contract.setOfferor(model.getOfferor());
		//审单人
		contract.setCheckBy(model.getCheckBy());
		//签期、船期、交期、说明
		contract.setSigningDate(model.getSigningDate());
		contract.setShipTime(model.getShipTime());
		contract.setDeliveryPeriod(model.getDeliveryPeriod());
		contract.setRemark(model.getRemark());
		
		baseDao.saveOrUpdate(contract);
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractService#deleteById(java.io.Serializable)
	 */
	@Override
	public void deleteById(Serializable ids) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable[] ids) {
		baseDao.delete(Contract.class, ids);
	}
	

}
