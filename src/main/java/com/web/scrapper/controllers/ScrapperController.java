package com.web.scrapper.controllers;

import com.web.scrapper.model.ScrappedModel;
import com.web.scrapper.web.ScrapperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class ScrapperController {

    private final ScrapperService scrapperService;

    public ScrapperController(ScrapperService scrapperService) {
        this.scrapperService = scrapperService;
    }

    @GetMapping
    public String index() {
        return "data/index";
    }

    @PostMapping(path = "/search")
    public String search(@RequestParam("query") String query, Model model) {
        try {
            List<ScrappedModel> scrappedData = scrapperService.init(query);
            model.addAttribute("resultsCount", scrappedData.size());
            model.addAttribute("products", scrappedData);
            model.addAttribute("query", query);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "data/index";
    }
}
