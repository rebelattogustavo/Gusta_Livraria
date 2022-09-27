package br.com.senai.exceptions;

public class SenhaIncorretaException extends Exception {
    public SenhaIncorretaException() {
        super("Senha incorreta!");
    }
}
