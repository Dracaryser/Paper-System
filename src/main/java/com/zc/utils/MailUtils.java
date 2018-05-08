package com.zc.utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {

    public static void sendMail(String to, String subject,String content) throws MessagingException {
        //连接邮件服务器
        Properties props = new Properties();
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("system@paper.com","123");
            }
        });
        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        message.setFrom(new InternetAddress("system@paper.com"));
        //设置收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        //设置邮件主题
        message.setSubject(subject);
        //设置邮件正文
        message.setContent(content,"text/html;charset=UTF-8");
        //发送邮件
        Transport.send(message);

    }
}
