# Spring PDF Generator

Uma solução simples para gerar arquivos PDF em aplicações Spring Boot, utilizando a biblioteca iTextPDF e templates Thymeleaf. Ideal para gerar relatórios dinâmicos ou documentos em PDF a partir de dados processados em uma aplicação Java.

## 🚀 Funcionalidades

- **Geração de PDF a partir de strings**: Criação de documentos PDF simples com conteúdo textual.
- **Geração de PDF via HTML e CSS**: Utiliza a engine Thymeleaf para renderizar templates HTML e gerar PDFs estilizados.
- **Forçar download de PDF via URL**: Implementação de uma URL `http://localhost:8080/download` que força o download de um PDF gerado dinamicamente.

## ⚙️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Thymeleaf**: Engine de templates para gerar o conteúdo HTML que será convertido em PDF.
- **iTextPDF**: Biblioteca utilizada para gerar os PDFs a partir de strings ou HTML.
- **Maven**: Gerenciador de dependências utilizado no projeto.

## 🛠️ Dependências

As principais dependências do Maven para o projeto são:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<!-- Biblioteca iTextPDF - Core -->
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>kernel</artifactId>
    <version>8.0.5</version>
</dependency>

<!-- Biblioteca iTextPDF - HTML para PDF -->
<dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>html2pdf</artifactId>
    <version>5.0.5</version>
</dependency>

<!-- Spring Boot DevTools (para facilitar o desenvolvimento) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>

<!-- Spring Boot Starter Web (para configurar a aplicação web) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
## 🔧 Instalação e Uso

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/otthonleao/spring-pdf-generator.git
   ```
2. Instale as dependências: Se você estiver usando o Maven, pode instalar as dependências e construir o projeto com o seguinte comando:
    ```bash
    mvn clean install
    ```
3. Executando a aplicação: Após a instalação das dependências, você pode iniciar o servidor Spring Boot com o comando:
    ```bash
    mvn spring-boot:run
    ```
4. Acessando a aplicação: Após o servidor iniciar, você pode acessar a aplicação via http://localhost:8080.

## 📚 Exemplos de Uso
- Gerar PDF com conteúdo simples:
    Acesse o endpoint `/relatorio` para gerar um PDF com conteúdo estático simples.
- Gerar PDF Dinâmico:
    Acesse o endpoint `/pdf-dinamico` para gerar um PDF utilizando um template Thymeleaf.
- Forçar download do PDF:
    Ao acessar o endpoint `/download`, o download do arquivo será forçado automaticamente pelo navegador.

