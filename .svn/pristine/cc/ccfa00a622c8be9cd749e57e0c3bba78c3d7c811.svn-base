/**
 * 
 */
package cn.yin.jx.utils;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @Description:
 * @author:     尹成功
 * @version:    1.0
 * @Company:    http://java.itcast.cn 
 * @date:       2017年2月21日
 */
public class MailUtil {
	public static void sendMail(String toAddress,String subject,String text) throws Exception {
		//1 设置发送电子邮件的参数
		Properties props = new Properties();
		//设置邮件服务器 smtp.qq.com   smtp.sina.com  smtp.163.com  smtp.aliyun.com
		props.put("mail.smtp.host", "smtp.163.com");
		// 验证是否打开
		props.put("mail.smtp.auth", "true");
		// 取得与服务器的连接
		Session session = Session.getInstance(props);
		// 创建一封邮件
		MimeMessage mimeMessage = new MimeMessage(session);
		// 设置发送者
		InternetAddress address = new InternetAddress("chenggongit@163.com");
		mimeMessage.setFrom(address);
		// 设置接收者
		InternetAddress toNetAddress = new InternetAddress(toAddress);
		//第一个参数:to：直接接收者人   ；cc 抄送； bcc：暗送
		mimeMessage.setRecipient(RecipientType.TO, toNetAddress);
		//6 设置邮件标题、内容
		mimeMessage.setSubject(subject);
		mimeMessage.setText(text);
		mimeMessage.saveChanges();
		//7 发送:坐火箭
		Transport transport = session.getTransport("smtp");
		// 登陆邮件
		transport.connect("smtp.163.com","chenggongit@163.com","b1270909658");
		//第一个参数：邮件内容
//		/第二个参数：所有的接收者
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		//关闭火箭
		transport.close();
		System.out.println("发送成功");
	}

}
