package com.br.adopt.pets.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.adopt.pets.service.EmailService;

@RestController
@RequestMapping("/api/v1/email-send")
public class EmailController {

	@Autowired
	private EmailService service;

	@PostMapping(path = "/{id}")
	public String sendMail(@PathVariable Long id ) {
		
		service.sendEmail(id);

		return "Erro ao enviar e-mail";
	}
}
