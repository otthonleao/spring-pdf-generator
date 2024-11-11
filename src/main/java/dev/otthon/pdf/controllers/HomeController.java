package dev.otthon.pdf.controllers;

import com.itextpdf.html2pdf.HtmlConverter;
import dev.otthon.pdf.models.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private TemplateEngine templateEngine;

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

    @GetMapping(value = "/pdf-dinamico", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] gerarPdfTemplateThymeleafDinamico() {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Spring Boot", "Otthon Leão", "40h"));
        cursos.add(new Curso("Git e GitHub", "Rafael Ferreira", "40h"));
        cursos.add(new Curso(".NET Framework", "Osmir Bresciani", "40h"));

        Context context = new Context();
        context.setVariable("cursos", cursos);

        String htmlStream = templateEngine.process("pdf-dinamico", context);
        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(htmlStream, pdfStream);

        return pdfStream.toByteArray();
    }

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public ResponseEntity<?> baixarPdf() {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Spring Boot", "Otthon Leão", "40h"));
        cursos.add(new Curso("Git e GitHub", "Rafael Ferreira", "40h"));
        cursos.add(new Curso(".NET Framework", "Osmir Bresciani", "40h"));

        Context context = new Context();
        context.setVariable("cursos", cursos);

        String htmlStream = templateEngine.process("pdf-dinamico", context);
        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(htmlStream, pdfStream);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=pdf-dinamico.pdf")
//                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfStream.toByteArray());
    }

}
