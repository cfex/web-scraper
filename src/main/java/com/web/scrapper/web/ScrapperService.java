package com.web.scrapper.web;

import com.web.scrapper.model.ScrappedModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrapperService {

    public List<ScrappedModel> init(String query) throws IOException {
        final String BASE_URL = "https://www.eponuda.com";
        /*
        / First we specify the url, connect and get content from it
        */
        Document document = Jsoup.connect(BASE_URL + "/uporedicene?ep=" + query).get();

        /*
        / We select elements by it's id value,
        / <div id="#pr_view_grid"> .. </div>
        */
        Element elements = document.getElementById("pr_view_grid");

        /*
        / If we successfully get elements by id,
        / we can select all it's divs
        */
        Elements divs = elements.select(".product.b-paging-product.b-paging-product--vertical");

        /*
        / We initialize new ArrayList, where we will store our objects
        */
        List<ScrappedModel> scrappedModels = new ArrayList<>();

        /*
        / We loop through all divs,
        / select specific div and take it's value
        */
        for(Element div : divs) {
            ScrappedModel data = new ScrappedModel();

            String price = div.select(".b-paging-product__price").text();
            String title = div.select(".b-paging-product__title").text();
            String discount = div.select(".discount-p").text();
            String url = div.select("a").first().attr("href");

            /*
            / Assign values to the object,
            / add it to array and send it back as response
            */
            data.setPrice(price);
            data.setName(title);
            data.setDiscount(discount);
            /*
            / Concatenate BASE_URL
            / to url gotten from scrapped element
            */
            data.setUrl(BASE_URL + url);

            scrappedModels.add(data);
        }

        return scrappedModels;
    }
}
