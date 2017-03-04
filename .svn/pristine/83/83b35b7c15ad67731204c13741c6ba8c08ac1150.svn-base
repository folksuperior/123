/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.Factory;
import cn.yin.jx.service.FactoryService;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class FactoryServiceImpl implements FactoryService{
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.FactoryService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<Factory> findPage(String hql, Page page, Class<Factory> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.FactoryService#get(java.lang.String)
	 */
	@Override
	public Factory get(String id) {
		return baseDao.get(Factory.class, id);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.FactoryService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<Factory> find(String hql, Class<Factory> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.FactoryService#save(cn.yin.jx.domain.Factory)
	 */
	@Override
	public void save(Factory model) {
		baseDao.saveOrUpdate(model);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.FactoryService#saveOrUpdate(cn.yin.jx.domain.Factory)
	 */
	@Override
	public void saveOrUpdate(Factory model) {
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.FactoryService#deleteById(java.io.Serializable)
	 */
	@Override
	public void deleteById(Serializable ids) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.FactoryService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable[] ids) {
		baseDao.delete(Factory.class, ids);
	}
	

}
