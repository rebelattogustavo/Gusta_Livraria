package br.com.senai.entities;

import java.util.ArrayList;

public class Revisor extends Pessoa{
    //Lista de livros que o revisor está revisando
    public static ArrayList<Livro> listaLivrosRevisor = new ArrayList<>();

    //Lista os livros que o revisor tem a opção de revisar com base no status "Aguardando Revisão"
    @Override
    public void listarLivros() {
        int cont = -1;
        for(int i =0;i<Main.listaLivros.size();i++){
            if(Main.listaLivros.get(i).getStatus() == 1){
                System.out.println(Main.listaLivros.get(i).toString());
                cont++;
            }
        }
        if(cont == -1){
            System.out.println("Nenhum livro cadastrado!");
        }
    }

    //Função que permite o revisor editar um livro
    @Override
    public void editarLivro() throws Exception {
        int indiceLivro = Main.verificaLivro();
        if(indiceLivro == -1){
            System.out.println("Livro não encontrado!");
            Main.menuPrincipal();
        }
        if(Main.listaLivros.get(indiceLivro).getStatus() == 1){
            Main.listaLivros.get(indiceLivro).setStatus(2);
            this.listaLivrosRevisor.add(Main.listaLivros.get(indiceLivro));
        }else if(Main.listaLivros.get(indiceLivro).getStatus() == 2){
            int opcaoEdita = Main.selecionaTipoEditar("revisão", indiceLivro);
            switch (opcaoEdita){
                case 1:
                    if(Main.listaLivros.get(indiceLivro).getPorcentagem() == 100){
                        Main.listaLivros.get(indiceLivro).setStatus(4);
                    }
                    break;
                case 2:
                    Main.listaLivros.get(indiceLivro).setStatus(5);
                    break;
                case 3:
                    Main.listaLivros.get(indiceLivro).setStatus(3);
                    break;
            }
        }
    }

    //Função que informa as opções disponíveis para revisor no menu principal
    @Override
    public String[] opcoes() {
        return new String[]{
                "1- Listar atividades" ,
                "2- Listar livros" ,
                "3- Logout" ,
                "4- Encerrar"
        };
    }

    //Função que lista as atividades de um revisor com base no status "Em revisão"
    @Override
    public String listarAtividade() {
        String livros = "";
        for(int i =0;i< this.listaLivrosRevisor.size();i++){
            livros += listaLivrosRevisor.get(i).toString();
        }
        return livros;
    }

    //Construtor da classe Revisor
    public Revisor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
    }



}
