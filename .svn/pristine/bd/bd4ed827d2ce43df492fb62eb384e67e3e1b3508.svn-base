/**
 * 
 */
package cn.yin.jx.service;

import java.io.Serializable;
import java.util.List;

import cn.yin.jx.domain.ExtCproduct;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public interface ExtCproductService {
	public abstract Page<ExtCproduct> findPage(String hql,Page page,Class<ExtCproduct> entityClass,Object[] params);

	public abstract ExtCproduct get(String id);

	/**
	 * 
	 * @Description:
	 * @param hql
	 * @param entityClass
	 * @param params
	 * @return
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月18日上午10:56:19
	 */
	public List<ExtCproduct> find(String hql, Class<ExtCproduct> entityClass, Object[] params);

	/**
	 * 
	 * @Description:
	 * @param model
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月18日上午10:56:29
	 */
	public abstract void save(ExtCproduct model);

	/**
	 * 
	 * @Description:
	 * @param model
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月18日上午10:56:33
	 */
	public abstract void saveOrUpdate(ExtCproduct model);

	/**
	 * 
	 * @Description:
	 * @param ids
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月18日上午10:56:40
	 */
	public abstract void deleteById(Serializable ids);
	
	/**
	 * @Description:
	 * @param ids
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月18日上午10:56:45
	 */
	public abstract void delete(Class entity,ExtCproduct model);
}
