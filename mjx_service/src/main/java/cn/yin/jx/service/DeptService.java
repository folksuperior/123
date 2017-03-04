package cn.yin.jx.service;

import java.io.Serializable;
import java.util.List;

import cn.yin.jx.domain.Dept;
import cn.yin.jx.utils.Page;

/**
 * 
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月15日
 */
public interface DeptService {
	/**
	 * 
	 * @Description:
	 * @param hql
	 * @param page:分页的工具
	 * @param entityClass：对哪个类进行分页查找
	 * @param params：分页的参数信息
	 * @return
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月15日下午7:34:00
	 */
	public abstract Page<Dept> findPage(String hql,Page page,Class<Dept> entityClass,Object[] params);

	public abstract Dept get(String id);

	/**
	 * @Description:
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月17日下午7:49:29
	 */
	public List<Dept> find(String hql, Class<Dept> entityClass, Object[] params);

	/**
	 * @Description:
	 * @param model
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月17日下午8:04:49
	 */
	public abstract void save(Dept model);

	/**
	 * @Description:
	 * @param model
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月17日下午9:47:59
	 */
	public abstract void saveOrUpdate(Dept model);

	/**
	 * @Description:
	 * @param ids
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月17日下午10:35:06
	 */
	public abstract void deleteById(Serializable ids);
	
	/**
	 * @Description:
	 * @param ids
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月17日下午10:35:07
	 */
	public abstract void delete(Serializable[] ids);
	
}
