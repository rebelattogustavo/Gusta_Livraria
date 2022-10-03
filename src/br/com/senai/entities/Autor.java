package br.com.senai.entities;

import br.com.senai.exceptions.CodInvalidoException;
import br.com.senai.exceptions.LivroExistenteException;
import br.com.senai.exceptions.QtdPagInvalidaException;

import java.util.Scanner;

public class Autor extends Pessoa{
    public static Scanner tec = new Scanner(System.in);

    /**
     * Função que lista os livros cadastrados no sistema pelo autor
     * @throws Exception
     */
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

    /**
     * Função que permite o autor editar algum livro cadastrado
     * @throws Exception
     */
    @Override
    public void editarLivro() throws Exception {
        int indicelivro = Main.verificaLivro();
        if(indicelivro == -1){
            System.out.println("Livro não encontrado!");
            Main.menuPrincipal();
        }
        Main.listaLivros.get(indicelivro).setStatus(1);
    }

    /**
     * Função que permite o autor cadastrar um novo livro no sistema
     * @throws Exception
     */
    public static void cadastrarLivro() throws Exception {

        System.out.print("--- CADASTRO DE LIVROS ---" +
                "\nTítulo: ");
        String tituloLivro = tec.next();
        for(int i=0; i< Main.listaLivros.size();i++){
            if(tituloLivro.equals(Main.listaLivros.get(i).getTitulo())){
                throw new LivroExistenteException();
            }
        }
        System.out.print("Quantidade de páginas: ");
        int qtdPagLivro = tec.nextInt();
        if(qtdPagLivro < 0){
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
        Livro livroCadastro = new Livro(tituloLivro,(Autor) Main.user ,1, qtdPagLivro, isbn);
        Main.listaLivros.add(livroCadastro);
    }

    /**
     * Função que permite um novo autor se cadastrar no sistema
     */
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

    /**
     * Função que informa as opções disponíveis para o autor no menu principal
     */
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

    /**
     * Função que lista as atividades de um autor com base no status "Aguardando edição"
     * @throws Exception
     */
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

    /**
     * Construtor da classe Autor
     * @param nomeAutor
     * @param cpfAutor
     * @param sobrenomeAutor
     * @param emailAutor
     * @param generoAutor
     * @param senhaAutor
     */
    public Autor(String nomeAutor, String cpfAutor, String sobrenomeAutor, String emailAutor,
                 String generoAutor, String senhaAutor) {
        super(nomeAutor, cpfAutor, sobrenomeAutor, emailAutor, generoAutor, senhaAutor);
    }
}
