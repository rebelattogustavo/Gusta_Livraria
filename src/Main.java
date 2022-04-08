import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner tec = new Scanner(System.in);
    static int indicePessoa;
    static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    static ArrayList<Livro> listaLivros = new ArrayList<>();

    public static void main(String[] args) {
        String nome,cnpj, cpf, sobrenome, email, genero, senha="1";
        nome = "Gusta_Books";
        cnpj="13.912.556/0001-04";
        Editora editora = new Editora(nome, cnpj);

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

        menuInicial();
    }

    public static void menuInicial(){
        System.out.println("--- MENU INICIAL ---" +
                "\n1- Login" +
                "\n2- Cadastre-se");
        int opcao = tec.nextInt();
        switch (opcao){
            case 1:
                login();
                break;
            case 2:
                cadastro();
        }
    }

    public static void login(){
        System.out.print("Informe o seu nome: ");
        String nome = tec.next();
        for(int i=0; i< listaPessoas.size();i++){
            if(nome.equals(listaPessoas.get(i).getNome())){
                System.out.print("Informe a senha: ");
                String senha = tec.next();
                if(listaPessoas.get(i).getSenha().equals(senha)){
                    indicePessoa = i;
                    menuPrincipal();
                }else{
                    System.out.println("Senha ou nome incorreto(a)! Tente novamente");
                    login();
                }
            }
        }
    }

    public static void cadastro(){
        System.out.print("--- CADASTRO ---" +
                "\nNome: ");
        String nome = tec.next();
        System.out.print("CPF: ");
        String cpf = tec.next();
        System.out.print("Sobrenome: ");
        String sobrenome = tec.next();
        System.out.print("Email: ");
        String email = tec.next();
        System.out.print("Gênero: ");
        String genero = tec.next();
        System.out.print("Senha: ");
        String senha = tec.next();

        Autor autor = new Autor(nome, cpf, sobrenome, email, genero, senha);
        listaPessoas.add(autor);
    }

    private static void menuPrincipal(){
        int opcao=0;
        if(listaPessoas.get(indicePessoa) instanceof Revisor){
            System.out.println("--- MENU PRINCIPAL ---" +
                    "\n1- Listar atividade" +
                    "\n2- Listar livros" +
                    "\n3- Editar livros" +
                    "\n0- Encerrar");
            opcao = tec.nextInt();
            switch (opcao){
                case 1:
                    listarAtividade();
            }
        }else if(listaPessoas.get(indicePessoa) instanceof Autor){
            System.out.println("--- MENU PRINCIPAL ---" +
                    "\n1- Cadastrar livro" +
                    "\n2- Listar livros" +
                    "\n3- Editar livros" +
                    "\n0- Encerrar");
            opcao = tec.nextInt();
            switch (opcao){
                case 1:
                    cadastrarLivro();
            }
        }else if(listaPessoas.get(indicePessoa) instanceof Diretor){
            System.out.println("--- MENU PRINCIPAL ---" +
                    "\n1- Listar atividade" +
                    "\n2- Listar livros" +
                    "\n3- Editar livros" +
                    "\n4- Cadastrar revisor" +
                    "\n0- Encerrar");
            opcao = tec.nextInt();
            switch (opcao){
                case 1:
                    listarAtividade();
            }
        }
        switch (opcao){
            case 2:
                listarLivros();
                break;
            case 3:
                editarLivros();
                break;
            case 4:
                cadastrarRevisor();
                break;
            case 0:
                System.exit(0);
        }
    }

    private static void listarAtividade(){

    }

    private static void cadastrarLivro(){
        System.out.println("--- CADASTRO DE LIVROS ---" +
                "\nTítulo: ");
        String titulo = tec.next();
        System.out.println("Quantiade de páginas: ");
        int qtdPag = tec.nextInt();
        System.out.println("ISBN: ");
        int isbn = tec.nextInt();

        Livro livro = new Livro(titulo, 1, qtdPag, isbn, listaPessoas.get(indicePessoa).getNome(), listaPessoas.get(indicePessoa).getSobrenome());
        Autor.listaLivrosAutor.add(livro);
        listaLivros.add(livro);
    }

    private static void listarLivros(){
        if(listaPessoas.get(indicePessoa) instanceof Revisor){
            for(int i =0;i<listaLivros.size();i++){
                System.out.println(listaLivros.toString());
            }
        }
    }

    private static void editarLivros(){

    }

    private static void cadastrarRevisor(){

    }

}
