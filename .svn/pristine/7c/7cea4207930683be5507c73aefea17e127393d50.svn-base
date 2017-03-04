/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.Contract;
import cn.yin.jx.domain.ExtCproduct;
import cn.yin.jx.service.ExtCproductService;
import cn.yin.jx.utils.Page;
import cn.yin.jx.utils.UtilFuns;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ExtCproductServiceImpl implements ExtCproductService{
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtCproductService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<ExtCproduct> findPage(String hql, Page page, Class<ExtCproduct> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtCproductService#get(java.lang.String)
	 */
	@Override
	public ExtCproduct get(String id) {
		return baseDao.get(ExtCproduct.class, id);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtCproductService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<ExtCproduct> find(String hql, Class<ExtCproduct> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtCproductService#save(cn.yin.jx.domain.ExtCproduct)
	 */
	@Override
	public void save(ExtCproduct model) {
		double amount = 0d;
		if(UtilFuns.isNotEmpty(model.getCnumber()) && UtilFuns.isNotEmpty(model.getPrice())){
			amount = model.getCnumber()*model.getPrice();
			model.setAmount(amount);
			
			Contract contract = baseDao.get(Contract.class, model.getContractProduct().getContract().getId());
			Double oldTotalAmount = contract.getTotalAmount();
			contract.setTotalAmount(oldTotalAmount + amount);
			baseDao.saveOrUpdate(contract);
			
		}
		baseDao.saveOrUpdate(model);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtCproductService#saveOrUpdate(cn.yin.jx.domain.ExtCproduct)
	 */
	@Override
	public void saveOrUpdate(ExtCproduct model) {
		//会使用hibernate的一级缓存，直接从缓存中获取数据
		ExtCproduct ext = baseDao.get(ExtCproduct.class, model.getId());
		//	计算价格
		Double amount = 0d;
		if(UtilFuns.isNotEmpty(ext.getCnumber())&&UtilFuns.isNotEmpty(ext.getPrice())){
			amount = ext.getCnumber() * ext.getPrice();
		}
		//先修改购销合同的金额	
		Contract contract = baseDao.get(Contract.class, ext.getContractProduct().getContract().getId());
		//购销合同总金额 = 购销合同总金额  - 附件原始金额 +附件信的总额
		contract.setTotalAmount(contract.getTotalAmount() - ext.getAmount() + amount);
		
		//修改附件对应的金额
		ext.setAmount(amount);
		
		//修改购销合同
		baseDao.saveOrUpdate(contract);
		
		//设置属性
		baseDao.saveOrUpdate(ext);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtCproductService#deleteById(java.io.Serializable)
	 */
	@Override
	public void deleteById(Serializable ids) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtCproductService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Class entity,ExtCproduct model) {
		ExtCproduct obj = baseDao.get(ExtCproduct.class, model.getId());
		//2.得到购销合同对象
		Contract contract = baseDao.get(Contract.class, model.getContractProduct().getContract().getId());	
		//3.修改购销合同总金额   = 购销合同总金额-附件金额 
		contract.setTotalAmount(contract.getTotalAmount()-obj.getAmount()); 
		//4.删除附件对象
		baseDao.deleteById(ExtCproduct.class, model.getId()); 
		//5.保存购销合同总金额
		baseDao.saveOrUpdate(contract);
	}
	

}
