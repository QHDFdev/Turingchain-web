package com.tulingchain.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



/**
 * 发送邮件的工具类
 * 
 * @author wuyu
 *
 */
public class MailUitls {
	/**
	 * 发送邮件
	 * 
	 * @param to
	 *            发送的目的地
	 * @param sub
	 *            邮件主题
	 * @param attr
	 *            附件
	 * @param content
	 *            内容
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException
	 */
	public static boolean sendMail( String to, String content) {
		try {
			Properties props = new Properties();
			
			props.setProperty("mail.smtp.auth", "true");// 设置访问smtp服务器需要认证
			props.setProperty("mail.transport.protocol", "smtp"); // 设置访问服务器的协议

			Session session = Session.getDefaultInstance(props);
			session.setDebug(true); // 打开debug功能

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("WSGHRE@163.com")); // 设置发件人，163邮箱要求发件人与登录用户必须一致（必填），其它邮箱不了解
			// msg.setText(content); // 设置邮件内容
			msg.setSubject("来自图灵的邮件哦！"); // 设置邮件主题
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setContent("<h1>来自 TulingChain 的邮件!您已通过验证，以下是您的授权码:</h1><h3>"+content+"</a></h3>".toString(), "text/html;charset=utf-8"); // 设置发送内容
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp);
			msg.setContent(mp); // 发送附件
			Transport trans = session.getTransport();
			trans.connect("smtp.163.com", 25, "WSGHRE@163.com", "hanbei1993"); // 连接邮箱smtp服务器，25为默认端口
			trans.sendMessage(msg, new Address[] { new InternetAddress(to) }); // 发送邮件
			trans.close(); // 关闭连接
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @param from
	 *            发送方地址
	 * @param frompwd
	 *            发送方邮件密码
	 * @param to
	 *            发送的目的地
	 * @param sub
	 *            邮件主题
	 * @param content
	 *            内容
	 *            	 */
	
	public static void main(String[] args) {
		sendMail("15069917@qq.com","111111");
	}
}
