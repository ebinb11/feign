package com.feign.feign.service;

import com.feign.feign.entity.User;

public interface MailService {

	void sendMail(final String to, final String subject, final String text);
	
	public void esafNotification(User user);
	
}
