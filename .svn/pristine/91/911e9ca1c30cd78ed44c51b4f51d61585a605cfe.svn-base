/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.Contract;
import cn.yin.jx.domain.ContractProduct;
import cn.yin.jx.domain.Factory;
import cn.yin.jx.service.ContractProductService;
import cn.yin.jx.service.FactoryService;
import cn.yin.jx.utils.Page;
import cn.yin.jx.utils.UtilFuns;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ContractProductServiceImpl implements ContractProductService{
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractProductService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<ContractProduct> findPage(String hql, Page page, Class<ContractProduct> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractProductService#get(java.lang.String)
	 */
	@Override
	public ContractProduct get(String id) {
		return baseDao.get(ContractProduct.class, id);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractProductService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<ContractProduct> find(String hql, Class<ContractProduct> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractProductService#save(cn.yin.jx.domain.ContractProduct)
	 */
	@Override
	public void save(ContractProduct model) {
		double amount = 0d;
		if(UtilFuns.isNotEmpty(model.getCnumber()) && UtilFuns.isNotEmpty(model.getPrice())){
			amount = model.getCnumber() * model.getPrice();
			model.setAmount(amount);
		}
		Contract contract = baseDao.get(Contract.class, model.getContract().getId());
		contract.setTotalAmount(contract.getTotalAmount()+ amount);
		
		baseDao.saveOrUpdate(model);
		baseDao.saveOrUpdate(contract);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractProductService#saveOrUpdate(cn.yin.jx.domain.ContractProduct)
	 */
	@Override 
	public void saveOrUpdate(ContractProduct model) {
		Factory factory = baseDao.get(Factory.class,model.getFactory().getId());
		ContractProduct contractProduct = baseDao.get(ContractProduct.class, model.getId());
		//生产厂家
		contractProduct.setFactory(factory);
		//生产厂家名称
		contractProduct.setFactoryName(factory.getFactoryName());
		//货物照片
		contractProduct.setProductImage(model.getProductImage());
		//数量
		contractProduct.setCnumber(model.getCnumber());
		//装率
		contractProduct.setLoadingRate(model.getLoadingRate());
		//单价
		contractProduct.setPrice(model.getPrice());
		//货描
		contractProduct.setProductDesc(model.getProductDesc());
		//货号
		contractProduct.setProductNo(model.getProductNo());
		//包装单位
		contractProduct.setPackingUnit(model.getPackingUnit());
		//箱数
		contractProduct.setBoxNum(model.getBoxNum());
		//排序号
		contractProduct.setOrderNo(model.getOrderNo());
		//要求
		contractProduct.setProductRequest(model.getProductRequest());
		
		//设置修改价格
		Double amount = 0d;
		if(UtilFuns.isNotEmpty(contractProduct.getCnumber())&&UtilFuns.isNotEmpty(contractProduct.getPrice())){
			amount = contractProduct.getCnumber() * contractProduct.getPrice();
		}
		//购销合同呢?
		Contract contract = contractProduct.getContract();
		//购销合同的金额 = 购销合同原来的总价 - 货物原来的价格 + 新的价格
		contract.setTotalAmount(contract.getTotalAmount() - contractProduct.getAmount() + amount );
		// 更新当前货物的总价
		contractProduct.setAmount(amount);
		//更新合同
		baseDao.saveOrUpdate(contract);
		//更新货物
		baseDao.saveOrUpdate(contractProduct);
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractProductService#deleteById(java.io.Serializable)
	 */
	@Override
	public void deleteById(Serializable ids) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ContractProductService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable[] ids) {
		baseDao.delete(ContractProduct.class, ids);
	}
	

}
