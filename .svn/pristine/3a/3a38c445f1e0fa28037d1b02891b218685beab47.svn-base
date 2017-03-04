/**
 * 
 */
package cn.yin.jx.service;

import java.io.Serializable;
import java.util.List;

import cn.yin.jx.domain.ExportProduct;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public interface ExportProductService {
	public abstract Page<ExportProduct> findPage(String hql,Page page,Class<ExportProduct> entityClass,Object[] params);

	public abstract ExportProduct get(String id);

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
	public List<ExportProduct> find(String hql, Class<ExportProduct> entityClass, Object[] params);

	/**
	 * 
	 * @Description:
	 * @param model
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月18日上午10:56:29
	 */
	public abstract void save(ExportProduct model);

	/**
	 * 
	 * @Description:
	 * @param model
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月18日上午10:56:33
	 */
	public abstract void saveOrUpdate(ExportProduct model);

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
	public abstract void delete(Serializable[] ids);
}
