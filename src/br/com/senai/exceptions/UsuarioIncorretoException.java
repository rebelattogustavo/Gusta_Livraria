package br.com.senai.exceptions;

public class UsuarioIncorretoException extends Exception {
    public UsuarioIncorretoException() {
        super("Usuário incorreto!");
    }
}
