package br.com.senai.entities;

import br.com.senai.exceptions.*;

import java.util.ArrayList;
import java.util.Scanner;

//O sistema GustaLivraria foi desenvolvido por: Gustavo Rebelatto Zapella
//Tem como objetivo ser um sistema de gerenciamento de livros e autores para uma biblioteca
//Ter controle do fluxo do status do livro desde sua criação até ele ser publicado e ser cadastrado uma editora nele

public class Main {
    private static Scanner tec = new Scanner(System.in);
    public static int indicePessoa;
    public static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    public static ArrayList<Livro> listaLivros = new ArrayList<>();
    public static Pessoa user;
    public static Editora editora = new Editora();

    public static void main(String[] args) {
        adicionaDadosTeste();
        menuInicial();
    }

    /**
     * Função que direciona o usuário para as opções de login e cadastro. Também proporciona o usuário sair do programa
     * @throws OpcaoInvalidaException
     */
    public static void menuInicial(){
        try{
            System.out.println("--- MENU INICIAL ---" +
                    "\n1- Login" +
                    "\n2- Cadastre-se" +
                    "\n0- Encerrar");
            int opcao = tec.nextInt();
            if(opcao > 2 || opcao < 0){
                throw new OpcaoInvalidaException();
            }
            switch (opcao){
                case 1:
                    login();
                    break;
                case 2:
                    Autor autor = (Autor) user;
                    autor.cadastroDeAutor();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }catch (Exception erro) {
            System.out.println("Deu ruim\n"
                    + erro.getClass().getSimpleName() + ": "
                    + erro.getMessage());
            if (erro.getClass().getSimpleName().equals("OpcaoInvalidaException")) {
                menuInicial();
            }
        }
    }

    /**
     * Função que permite o usuário logar no sistema
     * @throws UsuarioIncorretoException
     * @throws SenhaIncorretaException
     */
    public static void login() {
        try{
            int verificaUsuario = 0;
            System.out.print("Informe o seu nome: ");
            String nome = tec.next();
            for(int i=0; i< listaPessoas.size();i++){
                if(nome.equals(listaPessoas.get(i).getNome())){
                    System.out.print("Informe a senha: ");
                    String senha = tec.next();
                    System.out.println(listaPessoas.get(i).getSenha());
                    if(listaPessoas.get(i).getSenha().equals(senha)){
                        indicePessoa = i;
                        user = listaPessoas.get(i);
                        verificaUsuario =0;
                        menuPrincipal();
                    }else{
                        throw new SenhaIncorretaException();
                    }
                }else {
                    verificaUsuario =1;
                }
            }
            if(verificaUsuario == 1){
                throw new UsuarioIncorretoException();
            }
        }catch (Exception erro) {
            System.out.println("Deu ruim\n"
                    + erro.getClass().getSimpleName() + ": "
                    + erro.getMessage());
            if (erro.getClass().getSimpleName().equals("br.com.senai.Exceptions.SenhaIncorretaException") ||
                    erro.getClass().getSimpleName().equals("br.com.senai.Exceptions.UsuarioIncorretoException")) {
                login();
            }
        }
    }

    /**
     * Função que direciona o usuário para as opções de menu principal dependendo de seu nível de acesso no sistema
     * @throws Exception
     */
    public static void menuPrincipal() throws Exception {
        try{
            System.out.println("---- MENU PRINCIPAL ----");
            String[] opcoesMenu = user.opcoes();
            for(String opcao : opcoesMenu){
                System.out.println(opcao);
            }
            int escolha = tec.nextInt();
            if(escolha == opcoesMenu.length){
                System.exit(0);
            }else if(escolha == (opcoesMenu.length - 1)){
                menuInicial();
            }else if(escolha < 1 || escolha > opcoesMenu.length){
                throw new OpcaoInvalidaException();
            }else{
                switch (escolha){
                    case 1:
                        System.out.println(user.listarAtividade());
                        if(user.listarAtividade().equals("")){
                            System.out.println("Nenhuma atividade para listar!");
                            menuPrincipal();
                        }
                        System.out.println("Deseja editar um dos livros acima?");
                        char resp = tec.next().charAt(0);
                        if(resp == 's' || resp == 'S'){
                            user.editarLivro();
                        }else if(resp == 'n' || resp == 'N'){

                        }else{
                            System.out.println("ANTA digita direito!!");
                        }
                        menuPrincipal();
                        break;
                    case 2:
                        user.listarLivros();
                        System.out.println("Deseja adicionar algum livro a sua lista de atividade?");
                        resp = tec.next().charAt(0);
                        if(resp == 's' || resp == 'S'){
                            user.editarLivro();
                        }else if( resp == 'n' || resp == 'N'){
                            menuPrincipal();
                        }
                        menuPrincipal();
                        break;
                    case 3:
                        if(user instanceof Diretor){
                            Diretor diretor = (Diretor) user;
                            diretor.cadastrarRevisor();
                        }else {
                            Autor autor = (Autor) user;
                            autor.cadastrarLivro();
                        }
                        menuPrincipal();
                        break;
                }
            }
        }catch (Exception erro) {
            System.out.println("Deu ruim\n"
                    + erro.getClass().getSimpleName() + ": "
                    + erro.getMessage());
            if (erro.getClass().getSimpleName().equals("OpcaoInvalidaException")) {
                menuPrincipal();
            }else{
                Autor autor = (Autor) user;
                autor.cadastrarLivro();
            }
        }
    }

    /**
     * Função que informa ao usuário as opções de editar que ele tem dependendo de seu nível de acesso
     * @param opcaoMenu
     * @param indiceLivro
     * @throws OpcaoInvalidaException
     */

    public static int selecionaTipoEditar(String opcaoMenu, int indiceLivro) throws OpcaoInvalidaException {
        int opcao =0;
        if(user instanceof Revisor){
            System.out.print("Informe em qual página você parou a revisão: ");
            int pagLidas = tec.nextInt();
            Main.listaLivros.get(indiceLivro).mudarPorcent(Main.listaLivros.get(indiceLivro).getQtdPag(), pagLidas);

            System.out.println("Informe o status do livro após a " + opcaoMenu +
                    "\n1- Aprovar" +
                    "\n2- Reprovar" +
                    "\n3- Solicitar edição");
            opcao = tec.nextInt();
        }else if(user instanceof Diretor){
            System.out.println("Informe o status do livro após a " + opcaoMenu +
                    "\n1- Publicar" +
                    "\n2- Reprovar" +
                    "\n3- Retornar ao revisor");
            opcao = tec.nextInt();
        }
        if(opcao > 3 || opcao < 1){
            throw new OpcaoInvalidaException();
        }
            return opcao;
    }

    /**
     * Função que verifica se o livro que o usuário deseja editar existe
     */
    public static int verificaLivro(){
        System.out.print("Informe o ISBN do livro que você deseja editar: ");
        String isbn = tec.next();
        for (int i=0;i<listaLivros.size();i++){
            if(listaLivros.get(i).getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Função que adiciona dados teste para o programa
     * esses dados não são necessários para o funcionamento do mesmo
     */
    public static void adicionaDadosTeste(){
        String nome,cnpj, cpf, sobrenome, email, genero, senha="1";
        editora.setNomeEditora("Gusta_Books");

        nome = "gu";
        cpf = "106.141.649-66";
        sobrenome = "Rebelatto";
        email = "gu.zapella@gmail.com";
        genero = "Masculino";
        Diretor diretor = new Diretor(nome, cpf, sobrenome, email, genero, senha);
        listaPessoas.add(diretor);

        nome = "leo";
        cpf = "106.141.648-66";
        sobrenome = "Rafaelli";
        email = "leo.rafaelli@gmail.com";
        genero = "Masculino";
        Autor autor = new Autor(nome, cpf, sobrenome, email, genero, senha);
        listaPessoas.add(autor);

        nome = "ota";
        cpf = "109.141.649-66";
        sobrenome = "Augusto";
        email = "ota.augusto@gmail.com";
        genero = "Masculino";
        Revisor revisor = new Revisor(nome,cpf,sobrenome,email,genero,senha);
        listaPessoas.add(revisor);
    }
}