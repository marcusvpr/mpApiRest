package com.mpxds.apirest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.mail.SimpleMailMessage;

public class MpMockEmailService extends MpAbstractEmailService {
	//
	private static final Logger LOG = LoggerFactory.getLogger(MpMockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		//
		LOG.info("Simulando envio de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
	}
}
