/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.ExportProduct;
import cn.yin.jx.service.ExportProductService;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ExportProductServiceImpl implements ExportProductService{
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportProductService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<ExportProduct> findPage(String hql, Page page, Class<ExportProduct> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportProductService#get(java.lang.String)
	 */
	@Override
	public ExportProduct get(String id) {
		return baseDao.get(ExportProduct.class, id);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportProductService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<ExportProduct> find(String hql, Class<ExportProduct> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportProductService#save(cn.yin.jx.domain.ExportProduct)
	 */
	@Override
	public void save(ExportProduct model) {
		baseDao.saveOrUpdate(model);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportProductService#saveOrUpdate(cn.yin.jx.domain.ExportProduct)
	 */
	@Override
	public void saveOrUpdate(ExportProduct model) {
		if(StringUtils.isBlank(model.getId())){
			
			
		}else{
			
		}
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportProductService#deleteById(java.io.Serializable)
	 */
	@Override
	public void deleteById(Serializable ids) {
		//TODO
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExportProductService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable[] ids) {
		baseDao.delete(ExportProduct.class, ids);
	}
	

}
