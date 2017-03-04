/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.Role;
import cn.yin.jx.service.RoleService;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class RoleServiceImpl implements RoleService{
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.RoleService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<Role> findPage(String hql, Page page, Class<Role> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.RoleService#get(java.lang.String)
	 */
	@Override
	public Role get(String id) {
		return baseDao.get(Role.class, id);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.RoleService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<Role> find(String hql, Class<Role> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.RoleService#save(cn.yin.jx.domain.Role)
	 */
	@Override
	public void save(Role model) {
		baseDao.saveOrUpdate(model);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.RoleService#saveOrUpdate(cn.yin.jx.domain.Role)
	 */
	@Override
	public void saveOrUpdate(Role model) {
		if(StringUtils.isBlank(model.getId())){
			
			
		}else{
			Role role = baseDao.get(Role.class, model.getId());
			role.setName(model.getName());
			role.setRemark(model.getRemark());
			baseDao.saveOrUpdate(role);
		}
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.RoleService#deleteById(java.io.Serializable)
	 */
	@Override
	public void deleteById(Serializable ids) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.RoleService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable[] ids) {
		baseDao.delete(Role.class, ids);
	}
	

}
