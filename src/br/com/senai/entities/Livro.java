package br.com.senai.entities;

public class Livro {
    private String titulo, isbn;
    Autor autor;
    Editora editora;
    private int status, qtdPag;
    private double porcentagem = 0;


    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQtdPag() {
        return qtdPag;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Livro(String titulo, Autor autor, int status, int qtdPag, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
        this.qtdPag = qtdPag;
        this.isbn = isbn;
    }

    public void mudarPorcent(int qtdPag, int paglidas){
        this.porcentagem = (paglidas * 100)/qtdPag;
    }

     @Override
    public String toString() {
        String outputLivro =  "Livro: " +
                "Titulo: '" + titulo + '\'' +
                " | Nome do autor: " + getAutor().getNome() + " " + getAutor().getSobrenome() +
                " | Status: " + status +
                " | Quantidade de páginas: " + qtdPag +
                " | ISBN: " + isbn +
                " | Foi revisado: " + getPorcentagem() + "% do livro";
                if(this.getEditora() != null) {
                    outputLivro += " | Editora: " + getEditora().getNomeEditora();
                }
            return outputLivro;
    }

}
