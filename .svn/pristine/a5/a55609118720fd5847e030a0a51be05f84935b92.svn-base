/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.ExtEproduct;
import cn.yin.jx.service.ExtEproductService;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ExtEproductServiceImpl implements ExtEproductService{
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtEproductService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<ExtEproduct> findPage(String hql, Page page, Class<ExtEproduct> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtEproductService#get(java.lang.String)
	 */
	@Override
	public ExtEproduct get(String id) {
		return baseDao.get(ExtEproduct.class, id);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtEproductService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<ExtEproduct> find(String hql, Class<ExtEproduct> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtEproductService#save(cn.yin.jx.domain.ExtEproduct)
	 */
	@Override
	public void save(ExtEproduct model) {
		baseDao.saveOrUpdate(model);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtEproductService#saveOrUpdate(cn.yin.jx.domain.ExtEproduct)
	 */
	@Override
	public void saveOrUpdate(ExtEproduct model) {
		if(StringUtils.isBlank(model.getId())){
			
			
		}else{
			
		}
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtEproductService#deleteById(java.io.Serializable)
	 */
	@Override
	public void deleteById(Serializable ids) {
		//TODO
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ExtEproductService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable[] ids) {
		baseDao.delete(ExtEproduct.class, ids);
	}
	

}
