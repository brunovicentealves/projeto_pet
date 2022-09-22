package com.br.adopt.pets.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class EmailController {


  @Autowired
  private JavaMailSender mailSender;


  @RequestMapping(path = "/email-send", method = RequestMethod.GET)
  public String sendMail() {
    try {
      MimeMessage mail = mailSender.createMimeMessage();

      MimeMessageHelper helper = new MimeMessageHelper(mail);
      helper.setTo("elsonss1988@gmail.com");
      helper.setSubject("Interesse no seu Pet");
      helper.setText(
          "<p>O contato elson se interesso pelo o seu Pet acesse o contato 11 999 888 777</p>",
          true);
      mailSender.send(mail);

      return "OK";
    } catch (Exception e) {
      e.printStackTrace();
      return "Erro ao enviar e-mail";
    }
  }
}


