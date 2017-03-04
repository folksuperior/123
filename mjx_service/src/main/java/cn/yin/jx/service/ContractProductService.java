/**
 * 
 */
package cn.yin.jx.service;

import java.io.Serializable;
import java.util.List;

import cn.yin.jx.domain.ContractProduct;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public interface ContractProductService {
	public abstract Page<ContractProduct> findPage(String hql,Page page,Class<ContractProduct> entityClass,Object[] params);

	public abstract ContractProduct get(String id);

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
	public List<ContractProduct> find(String hql, Class<ContractProduct> entityClass, Object[] params);

	/**
	 * 
	 * @Description:
	 * @param model
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月18日上午10:56:29
	 */
	public abstract void save(ContractProduct model);

	/**
	 * 
	 * @Description:
	 * @param model
	 * @version 1.0
	 * @author 尹成功
	 * @time 2017年2月18日上午10:56:33
	 */
	public abstract void saveOrUpdate(ContractProduct model);

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
