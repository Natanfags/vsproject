package com.example.demo.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CreateConectionService {

    Document doc = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();

    public CreateConectionService() throws IOException {
    }

    public Document getDoc() {
        return this.doc;
    }

}
