# Gerador de PDF com iTextPDF
Uma das funcionalidades frequentes no mundo web é gerar arquivos no formato PDF para que os usuários possam fazer downloads.

O Spring Framework utiliza a biblioteca do iTextPDF de forma simples usando Strings ou usando templates estáticos podem utilizar HTML e CSS para serem renderizados em uma Engine Thymeleaf.

## 🚀 Funcionalidades
- Gerar PDF simples a partir de Strings
- Gerar PDF através de HTML e CSS renderizados pelo Thymeleaf
- Forçar o download por meio de uma URL

## ⚙️ Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Thymeleaf
- iTextPDF

### Depenências do Maven - `pom.xml`
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<!-- https://mvnrepository.com/artifact/com.itextpdf/kernel -->
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>kernel</artifactId>
    <version>8.0.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/com.itextpdf/html2pdf -->
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>html2pdf</artifactId>
    <version>5.0.5</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    artifactId>spring-boot-starter-web</artifactId>
</dependency>
```


