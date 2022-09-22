package com.br.adopt.pets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.br.adopt.pets.dtos.DonorCompletDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private DonorService donorService;
	

	
	
	public void sendEmail(Long donorId) {
		
		
		DonorCompletDTO dto =donorService.getDonorById(donorId);
		
		String toEmail = dto.getEmail();
		
		String subject = "Adoçao de Pet";
		
		String body = "<p>Estou Querendo adotar seu pet entre em contato comigo pelo whats -"+dto.getTelefone()+"</p>";
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("adoteonepet@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		
	log.info("Email enviado com sucesso");	
		
	}
	
	

}
