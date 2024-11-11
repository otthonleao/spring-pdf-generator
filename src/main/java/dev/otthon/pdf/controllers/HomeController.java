package dev.otthon.pdf.controllers;

import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] gerarPdfSimples() {
        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf("<h1>Olá, mundo!</h1>", pdfStream);
        return pdfStream.toByteArray();
    }

    @GetMapping(value = "/relatorio", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] gerarPdfArquivoHtml() throws IOException {
        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
        Resource htmlStream = resourceLoader.getResource("classpath:templates/relatorio.html");
        HtmlConverter.convertToPdf(htmlStream.getInputStream(), pdfStream);
        return pdfStream.toByteArray();
    }

}
