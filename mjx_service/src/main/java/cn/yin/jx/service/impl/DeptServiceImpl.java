/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.yin.jx.common.SysConstant;
import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.Dept;
import cn.yin.jx.service.DeptService;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月15日
 */
public class DeptServiceImpl implements DeptService{
	
	private BaseDao baseDao;
	

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


	/* (non-Javadoc)
	 * @see cn.yin.jx.service.DeptService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<Dept> findPage(String hql, Page page, Class<Dept> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}


	/* (non-Javadoc)
	 * @see cn.yin.jx.service.DeptService#get(java.lang.String)
	 */
	@Override
	public Dept get(String id) {
		return baseDao.get(Dept.class, id);
	}


	/* (non-Javadoc)
	 * @see cn.yin.jx.service.DeptService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<Dept> find(String hql, Class<Dept> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}


	/* (non-Javadoc)
	 * @see cn.yin.jx.service.DeptService#save(cn.yin.jx.domain.Dept)
	 */
	@Override
	public void save(Dept model) {
		baseDao.saveOrUpdate(model);
	}


	/* (non-Javadoc)
	 * @see cn.yin.jx.service.DeptService#saveOrUpdate(cn.yin.jx.domain.Dept)
	 */
	@Override
	public void saveOrUpdate(Dept model) {
		if(StringUtils.isBlank(model.getId())){
			model.setState(SysConstant.Enable);
			baseDao.saveOrUpdate(model);
			
		}else{
			
			Dept dept = baseDao.get(Dept.class, model.getId());
			dept.setDeptName(model.getDeptName());
			dept.setParent(model.getParent());
			dept.setState(model.getState());
			baseDao.saveOrUpdate(dept);
		}
	}


	/* (non-Javadoc)
	 * @see cn.yin.jx.service.DeptService#deleteById(java.lang.String)
	 */
	@Override
	public void deleteById(Serializable id) {
		List<Dept> list = baseDao.find("from Dept where parent.id = ?", Dept.class,new Serializable[] {id});
		if(list != null && list.size() != 0){
			
			for(Dept d : list){
				baseDao.deleteById(Dept.class, d.getId());
				
			}
		}
		if(baseDao.get(Dept.class, id)!=null){
			
			baseDao.deleteById(Dept.class, id);
		}
	}


	/* (non-Javadoc)
	 * @see cn.yin.jx.service.DeptService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable[] ids) {
		for(Serializable id : ids){
			this.deleteById( id);
		}
	}
	
	

}
