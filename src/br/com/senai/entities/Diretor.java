package br.com.senai.entities;

import java.util.Scanner;

public class Diretor extends Pessoa{

    /**
     * Função que lista todos os livros cadastrados no sistema
     */
    @Override
    public void listarLivros() throws Exception {
        int verificaLivros = -1;
        for(int i =0;i<Main.listaLivros.size();i++){
            System.out.println(Main.listaLivros.get(i).toString());
            verificaLivros++;
        }
        if (verificaLivros == -1) {
            System.out.println("Nenhum livro para listar!");
            Main.menuPrincipal();
        }
    }

    /**
     * Função que permite o diretor editar um livro cadastrado
     */
    @Override
    public void editarLivro() throws Exception {
        int indiceLivro = Main.verificaLivro();
        if(indiceLivro == -1){
            System.out.println("Livro não encontrado!");
            Main.menuPrincipal();
        }
        int opcaoEdita = Main.selecionaTipoEditar("passagem pelo revisor", indiceLivro);
        switch (opcaoEdita){
            case 1:
                Main.listaLivros.get(indiceLivro).setStatus(6);
                Main.listaLivros.get(indiceLivro).setEditora(Main.editora);
                break;
            case 2:
                Main.listaLivros.get(indiceLivro).setStatus(5);
                break;
            case 3:
                Main.listaLivros.get(indiceLivro).setStatus(1);
                break;
        }
    }

    /**
     * Função que permite o diretor cadastrar um novo revisor no sistema
     */
    public static void cadastrarRevisor(){
        Scanner tec = new Scanner(System.in);
        System.out.print("Informe as informações a seguir: " +
                "\nNome do revisor: ");
        String nomeRevisor = tec.next();
        System.out.print("Informe o sobrenome do revisor: ");
        String sobrenomeRevisor = tec.next();
        System.out.print("Informe o CPF do revisor: ");
        String cpfRevisor = tec.next();
        System.out.print("Informe o gênero do revisor: ");
        String generoRevisor = tec.next();
        System.out.print("Informe o email do revisor: ");
        String emailRevisor = tec.next();
        System.out.print("Informe a senha do revisor: ");
        String senhaRevisor = tec.next();

        Revisor revisor = new Revisor(nomeRevisor, cpfRevisor, sobrenomeRevisor,
                emailRevisor, generoRevisor, senhaRevisor);
        Main.listaPessoas.add(revisor);
    }

    /**
     * Função que informa as opções disponíveis para diretor no menu principal
     */
    @Override
    public String[] opcoes() {
        return new String[]{
            "1- Listar atividades" ,
            "2- Listar livros" ,
            "3- Cadastrar revisor" ,
            "4- Logout" ,
            "5- Encerrar"};
    }

    /**
     * Função que lista as atividades do diretor com base no status "Aprovado"
     */
    @Override
    public String listarAtividade() {
        String listaLivros = "";
        for (int i =0;i<Main.listaLivros.size();i++){
            if(Main.listaLivros.get(i).getStatus() == 4){
                listaLivros += Main.listaLivros.get(i).toString();
            }
        }
        return listaLivros;
    }

    /**
     * Construtor da classe Diretor
     * @param nomeDiretor
     * @param cpfDiretor
     * @param sobrenomeDiretor
     * @param emailDiretor
     * @param generoDiretor
     * @param senhaDiretor
     */
    public Diretor(String nomeDiretor, String cpfDiretor, String sobrenomeDiretor,
                   String emailDiretor, String generoDiretor, String senhaDiretor) {
        super(nomeDiretor, cpfDiretor, sobrenomeDiretor, emailDiretor, generoDiretor, senhaDiretor);
    }
}
