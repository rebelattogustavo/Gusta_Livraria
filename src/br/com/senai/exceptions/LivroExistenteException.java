package br.com.senai.exceptions;

public class LivroExistenteException extends Exception {
    public LivroExistenteException() {
        super("Livro já existe!");
    }
}
