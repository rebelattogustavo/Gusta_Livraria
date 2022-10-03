package br.com.senai.entities;

public abstract class Pessoa {
    private String nome, cpf, sobrenome, email, genero, senha;

    public abstract void listarLivros() throws Exception;

    public abstract String listarAtividade() throws Exception;

    public abstract void editarLivro() throws Exception;

    public abstract String[] opcoes() throws Exception;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    //Construtor da classe Pessoa
    public Pessoa(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
        this.email = email;
        this.genero = genero;
        this.senha = senha;
    }

    //Função que define como uma pessoa será retornada no console
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", genero='" + genero + '\'' +
                ", senha='" + senha + '\'';
    }



}
