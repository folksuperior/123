/**
 * 
 */
package cn.yin.jx.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import cn.yin.jx.common.SysConstant;
import cn.yin.jx.dao.BaseDao;
import cn.yin.jx.domain.User;
import cn.yin.jx.service.UserService;
import cn.yin.jx.utils.Encrypt;
import cn.yin.jx.utils.Page;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月18日
 */
public class UserServiceImpl implements UserService{
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	private SimpleMailMessage mailMessage;
	public void setMailMessage(SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}

	private JavaMailSenderImpl mailSender;
	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.UserService#findPage(java.lang.String, cn.yin.jx.utils.Page, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public Page<User> findPage(String hql, Page page, Class<User> entityClass,
			Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.UserService#get(java.lang.String)
	 */
	@Override
	public User get(String id) {
		return baseDao.get(User.class, id);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.UserService#find(java.lang.String, java.lang.Class, java.lang.Object[])
	 */
	@Override
	public List<User> find(String hql, Class<User> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.UserService#save(cn.yin.jx.domain.User)
	 */
	@Override
	public void save(User model) {
		baseDao.saveOrUpdate(model);
	}

	// 创建随机六位密码
	private String getRandomPwd(){
		String pwd = "";
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		for(int i = 0 ; i < 6 ; i ++){
			int index = random.nextInt(str.length());
			pwd += str.charAt(index);
		}
		return pwd;
	}
	
	/* (non-Javadoc)
	 * @see cn.yin.jx.service.UserService#saveOrUpdate(cn.yin.jx.domain.User)
	 */
	@Override
	public void saveOrUpdate(final User model) {
		if(StringUtils.isBlank(model.getId())){
			String id = UUID.randomUUID().toString();
			String password = Encrypt.md5(SysConstant.DEFAULT_PASS, model.getUserName());
			model.setId(id);
			model.setPassword(password);
			model.getUserInfo().setId(id);
			baseDao.saveOrUpdate(model);
			new Thread(new Runnable(){
				/*
				public void run() {
					try {
						MailUtil.sendMail(model.getUserInfo().getEmail(), "杰信业务通知", ""
								+model.getUserName()+"：您好，欢迎加入杰信，您的初始密码是："+
								getRandomPwd()+"");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}}).start();*/
				public void run() {
					try {
						mailMessage.setTo(model.getUserInfo().getEmail());
						mailMessage.setSubject("亲爱的小猪");
						mailMessage.setText("让你久等了，么么哒");
						mailSender.send(mailMessage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}}).start();
		}else{
			User user = baseDao.get(User.class, model.getId());
			user.setUserName(model.getUserName());
			user.setState(model.getState());
			user.setDept(model.getDept());
			baseDao.saveOrUpdate(user);
		}
		
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.UserService#deleteById(java.io.Serializable)
	 */
	@Override
	public void deleteById(Serializable id) {
		User user = baseDao.get(User.class, id);
		if(user != null){
			baseDao.deleteById(User.class, id);
		}
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.UserService#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable[] ids) {
		for(Serializable id : ids){
			this.deleteById(id);
		}
	}

	/* (non-Javadoc)
	 * @see cn.yin.jx.service.UserService#findUserByName(java.lang.String)
	 */
	@Override
	public User findUserByName(String name) {
		List<User> userList = baseDao.find("from User where userName = ?", User.class, new String[] {name});
		if(userList == null || userList.size() == 0){
			return null;
			
		}
		return userList.get(0);
		
	}

}
