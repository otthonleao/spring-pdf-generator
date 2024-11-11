package dev.otthon.pdf.models;

public class Curso {

    private String nome;
    private String autor;
    private String CargaHoraria;

    public Curso(String nome, String autor, String cargaHoraria) {
        this.nome = nome;
        this.autor = autor;
        CargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }
}
