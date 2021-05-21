package com.jin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot08TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;


    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("hello刘颜");
        mailMessage.setText("你就是一个猪头");
        mailMessage.setTo("766332028@qq.com");
        mailMessage.setFrom("1726759661@qq.com");
        mailSender.send(mailMessage);

    }

    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //正文
        helper.setSubject("hello刘颜,你男盆友测试代码中");
        helper.setText("<h1 style='color:red'>爱你哦</h1>",true);
        //附件
        helper.addAttachment("kiss.jpg",new File("C:\\Users\\刘俊金\\Pictures\\kiss.jpg"));
        helper.setTo("1907910038@qq.com");
        helper.setFrom("1726759661@qq.com");
        mailSender.send(mimeMessage);

    }

    /**
     *
     * @param html
     * @param subject
     * @param text
     * @throws MessagingException
     * @author JJLiu
     */
    public void sendMail(Boolean html,String subject,String text) throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);
        //正文
        helper.setSubject(subject);
        helper.setText(text,true);
        //附件
        helper.addAttachment("kiss.jpg",new File("C:\\Users\\刘俊金\\Pictures\\kiss.jpg"));
        helper.setTo("1726759661@qq.com");
        helper.setFrom("1726759661@qq.com");
        mailSender.send(mimeMessage);
    }

}
