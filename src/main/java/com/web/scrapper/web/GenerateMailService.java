package com.web.scrapper.web;

import com.web.scrapper.model.ScrappedModel;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public class GenerateMailService {

    private TemplateEngine templateEngine;

    public GenerateMailService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String generateMail(List<ScrappedModel> products) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("products", products);

        final String templateFile = "mail";

        return templateEngine.process(templateFile, new Context(Locale.getDefault(), variables));
    }
}
