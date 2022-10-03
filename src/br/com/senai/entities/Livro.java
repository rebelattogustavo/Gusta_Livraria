package br.com.senai.entities;

public class Livro {
    private String titulo, isbn;
    private Autor autor;
    private Editora editora;
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

    /**
     * Construtor da classe Livro
     * @param titulo
     * @param autor
     * @param status
     * @param qtdPag
     * @param isbn
     */
    public Livro(String titulo, Autor autor, int status, int qtdPag, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
        this.qtdPag = qtdPag;
        this.isbn = isbn;
    }

    /**
     * Função que muda o percentual do livro que foi revisado
     * @param  qtdPag
     * @param paglidas
     */
    public void mudarPorcent(int qtdPag, int paglidas){
        this.porcentagem = (paglidas * 100)/qtdPag;
    }

    /**
     * Função que define como um livro será retornado no console
     */
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