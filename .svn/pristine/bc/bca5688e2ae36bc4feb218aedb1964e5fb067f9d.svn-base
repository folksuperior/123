/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.Module;
import cn.yin.jx.service.ModuleService;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class ModuleServiceImpl implements ModuleService{
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ModuleService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<Module> findPage(String hql, Page page, Class<Module> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ModuleService#get(java.lang.String)
	 */
	@Override
	public Module get(String id) {
		return baseDao.get(Module.class, id);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ModuleService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<Module> find(String hql, Class<Module> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ModuleService#save(cn.yin.jx.domain.Module)
	 */
	@Override
	public void save(Module model) {
		baseDao.saveOrUpdate(model);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ModuleService#saveOrUpdate(cn.yin.jx.domain.Module)
	 */
	@Override
	public void saveOrUpdate(Module model) {
		if(StringUtils.isBlank(model.getId())){
			
			
		}else{
			Module module = baseDao.get(Module.class, model.getId());
			module.setName(model.getName());
			module.setLayerNum(model.getLayerNum());
			module.setCpermission(module.getCpermission());
			module.setCurl(model.getCurl());
			module.setCtype(model.getCtype());
			module.setState(model.getState());
			module.setBelong(model.getBelong());
			module.setCwhich(model.getCwhich());
			module.setRemark(model.getRemark());
			module.setOrderNo(model.getOrderNo());
			
			baseDao.saveOrUpdate(module);
		}
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ModuleService#deleteById(java.io.Serializable)
	 */
	@Override
	public void deleteById(Serializable ids) {
		//TODO
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.ModuleService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable[] ids) {
		baseDao.delete(Module.class, ids);
	}
	

}
