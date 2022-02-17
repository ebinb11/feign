package com.feign.feign.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.feign.feign.entity.User;
import com.feign.feign.exception.BadDataException;
import com.feign.feign.service.MailService;



@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	TemplateEngine templateEngine;
	
	@Override
    public void sendMail(final String to, final String subject,
                         final String text) {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
//            message.setFrom(AppConstants.INFO_EMAIL_ID);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new BadDataException(e.getLocalizedMessage());
        }
    }

	@Override
	public void esafNotification(User user) {
        Context ctx = new Context();
        ctx.setVariable("firstName", user.getFirstName());
        ctx.setVariable("lastName", user.getLastName());
        ctx.setVariable("emailId", user.getEmail());
        String text = templateEngine.process("esafNotification.html", ctx);
        String subject = "ESAF APPLICATION";
        sendMail(user.getEmail(), subject, text);
	}

}
