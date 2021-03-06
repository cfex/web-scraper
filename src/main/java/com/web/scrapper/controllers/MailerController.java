package com.web.scrapper.controllers;

import com.web.scrapper.web.MailerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.mail.MessagingException;

@Controller
public class MailerController {

    private final MailerService mailerService;

    public MailerController(MailerService mailerService) {
        this.mailerService = mailerService;
    }

    @PostMapping(path = "/mail")
    public RedirectView send(@RequestParam("email") String email, @RequestParam("query") String query) throws MessagingException {
        mailerService.sendMail(email, query);

        return new RedirectView("redirect:/");
    }
}
