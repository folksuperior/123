/**
 * 
 */
package cn.yin.jx.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月19日
 */
public class Module extends BaseEntity{
	private String id;
	//父模块的编号
	private String parentId;
	//父模块的名字，冗余 用空间换时间
	private String parentName;
	//模块名
	private String name;
	//层数
	private Integer layerNum;
	//叶子
	private Integer isLeaf;
	//图片
	private String ico;
	//权限
	private String cpermission;
	//路径
	private String curl;
	//菜单的类型：主菜单、左侧菜单、按钮
	private Integer ctype;
	//状态
	private Integer state;
	//从属于
	private String belong;
	private String cwhich;
	//引用次数
	private Integer quoteNum;
	//备注
	private String remark;
	//排序号
	private Integer orderNo;
	
	private Set<Role> roles = new HashSet<Role>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLayerNum() {
		return layerNum;
	}

	public void setLayerNum(Integer layerNum) {
		this.layerNum = layerNum;
	}

	public Integer getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getCpermission() {
		return cpermission;
	}

	public void setCpermission(String cpermission) {
		this.cpermission = cpermission;
	}

	public String getCurl() {
		return curl;
	}

	public void setCurl(String curl) {
		this.curl = curl;
	}

	public Integer getCtype() {
		return ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public String getCwhich() {
		return cwhich;
	}

	public void setCwhich(String cwhich) {
		this.cwhich = cwhich;
	}

	public Integer getQuoteNum() {
		return quoteNum;
	}

	public void setQuoteNum(Integer quoteNum) {
		this.quoteNum = quoteNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", parentId=" + parentId + ", parentName="
				+ parentName + ", name=" + name + ", layerNum=" + layerNum
				+ ", isLeaf=" + isLeaf + ", ico=" + ico + ", cpermission="
				+ cpermission + ", curl=" + curl + ", ctype=" + ctype
				+ ", state=" + state + ", belong=" + belong + ", cwhich="
				+ cwhich + ", quoteNum=" + quoteNum + ", remark=" + remark
				+ ", orderNo=" + orderNo + "]";
	}

	
	// 更改默认的hashCode方法解决页面模块乱序问题
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
