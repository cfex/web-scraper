package com.web.scrapper.web;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailerService {

    private ScrapperService scrapperService;
    private final GenerateMailService generateMailService;
    private final JavaMailSender javaMailSender;

    public MailerService(ScrapperService scrapperService, GenerateMailService generateMailService, JavaMailSender javaMailSender) {
        this.scrapperService = scrapperService;
        this.generateMailService = generateMailService;
        this.javaMailSender = javaMailSender;
    }

    public MimeMessage sendMail(String recipient, String query) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        try {

            helper.setTo(recipient);
            helper.setSubject("Generated scrapper list");
            helper.setText(generateMailService.generateMail(scrapperService.init(query)), true);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return message;
    }
}
