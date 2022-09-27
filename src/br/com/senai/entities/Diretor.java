package br.com.senai.entities;

import java.util.Scanner;

public class Diretor extends Pessoa{
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

    @Override
    public String[] opcoes() {
        return new String[]{
            "1- Listar atividades" ,
            "2- Listar livros" ,
            "3- Cadastrar revisor" ,
            "4- Logout" ,
            "5- Encerrar"};
    }

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


    public Diretor(String nomeDiretor, String cpfDiretor, String sobrenomeDiretor,
                   String emailDiretor, String generoDiretor, String senhaDiretor) {
        super(nomeDiretor, cpfDiretor, sobrenomeDiretor, emailDiretor, generoDiretor, senhaDiretor);
    }
}
