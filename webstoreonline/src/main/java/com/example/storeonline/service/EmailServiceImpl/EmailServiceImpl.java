package com.example.storeonline.service.EmailServiceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.storeonline.model.EmailInfo;
import com.example.storeonline.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService{
    List<EmailInfo> emailInfo = new ArrayList<>();
    @Autowired
    JavaMailSender sender;

    @Override
    public void send(EmailInfo mail) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
        helper.setFrom(mail.getFrom());
        helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getBody(), true);
		helper.setReplyTo(mail.getFrom());
		
		String[] cc = mail.getCc();
		if(cc != null && cc.length > 0) {
			helper.setCc(cc);;
		}
		
		String[] bcc = mail.getBcc();
		if(bcc != null && bcc.length > 0) {
			helper.setBcc(bcc);
		}
		List<File> files = mail.getFiles();
		if (files.size()>0) {
			for (File file:files) {
				helper.addAttachment(file.getName(), file);
			}
		}
		sender.send(message);
    }
    
}
