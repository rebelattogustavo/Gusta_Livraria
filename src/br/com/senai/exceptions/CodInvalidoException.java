package br.com.senai.exceptions;

public class CodInvalidoException extends Exception {
    public CodInvalidoException() {
        super("Código inválido!");
    }
}
