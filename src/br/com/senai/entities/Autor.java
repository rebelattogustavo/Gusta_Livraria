package br.com.senai.entities;

import br.com.senai.exceptions.CodInvalidoException;
import br.com.senai.exceptions.LivroExistenteException;
import br.com.senai.exceptions.QtdPagInvalidaException;

import java.util.Scanner;

public class Autor extends Pessoa{
    public static Scanner tec = new Scanner(System.in);


    @Override
    public void listarLivros() throws Exception {
        int verificaLivros = -1;
        for (int i=0;i<Main.listaLivros.size();i++){
            if(Main.user == Main.listaLivros.get(i).getAutor()){
                System.out.println(Main.listaLivros.get(i).toString());
                verificaLivros++;
            }
        }
        if (verificaLivros == -1){
            System.out.println("Você cadastrou nenhum livro até o momento!");
            Main.menuPrincipal();
        }
    }

    @Override
    public void editarLivro() throws Exception {
        int indicelivro = Main.verificaLivro();
        if(indicelivro == -1){
            System.out.println("Livro não encontrado!");
            Main.menuPrincipal();
        }
        Main.listaLivros.get(indicelivro).setStatus(1);
    }

    public static void cadastrarLivro() throws Exception {

        System.out.print("--- CADASTRO DE LIVROS ---" +
                "\nTítulo: ");
        String titulo = tec.next();
        for(int i=0; i< Main.listaLivros.size();i++){
            if(titulo.equals(Main.listaLivros.get(i).getTitulo())){
                throw new LivroExistenteException();
            }
        }
        System.out.print("Quantidade de páginas: ");
        int qtdPag = tec.nextInt();
        if(qtdPag < 0){
            throw new QtdPagInvalidaException();
        }
        System.out.print("ISBN: ");
        String isbn = tec.next();
        for(int i =0; i< Main.listaLivros.size();i++){
            if(Main.listaLivros.get(i).getIsbn().equals(isbn)){
                throw new LivroExistenteException();
            }
        }
        if(isbn.length() != 13){
            throw new CodInvalidoException();
        }
        Livro livro = new Livro(titulo,(Autor) Main.user ,1, qtdPag, isbn);
        Main.listaLivros.add(livro);
    }

    public static void cadastroDeAutor() {
        System.out.print("--- CADASTRO ---" +
                "\nNome: ");
        String nomeAutor = tec.next();
        System.out.print("CPF: ");
        String cpfAutor = tec.next();
        System.out.print("Sobrenome: ");
        String sobrenomeAutor = tec.next();
        System.out.print("Email: ");
        String emailAutor = tec.next();
        System.out.print("Gênero: ");
        String generoAutor = tec.next();
        System.out.print("Senha: ");
        String senhaAutor = tec.next();

        Autor autor = new Autor(nomeAutor, cpfAutor, sobrenomeAutor, emailAutor, generoAutor, senhaAutor);
        Main.listaPessoas.add(autor);
        System.out.println("Cadastro realizado com sucesso!");
        Main.menuInicial();
    }

    @Override
    public String[] opcoes() {
        return new String[]{
            "1- Listar atividades" ,
            "2- Listar livros" ,
            "3- Cadastrar Livro" ,
            "4- Logout" ,
            "5- Encerrar"
        };
    }

    @Override
    public String listarAtividade() throws Exception {
        String listaLivros = "";
        int verificaAtividades = -1;
        for (int i=0;i<Main.listaLivros.size();i++){
            if(Main.user == Main.listaLivros.get(i).getAutor() && Main.listaLivros.get(i).getStatus() == 3){
                listaLivros += Main.listaLivros.get(i).toString();
                verificaAtividades++;
            }
        }
        if (verificaAtividades == -1){
            System.out.println("Nenhuma atividade até o momento!");
            Main.menuPrincipal();
        }
        return listaLivros;
    }

    public Autor(String nomeAutor, String cpfAutor, String sobrenomeAutor, String emailAutor,
                 String generoAutor, String senhaAutor) {
        super(nomeAutor, cpfAutor, sobrenomeAutor, emailAutor, generoAutor, senhaAutor);
    }
}
