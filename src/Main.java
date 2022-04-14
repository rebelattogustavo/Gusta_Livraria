import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner tec = new Scanner(System.in);
    public static int indicePessoa;
    public static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    public static ArrayList<Livro> listaLivros = new ArrayList<>();
    public static Pessoa user;
    public static Editora editora = new Editora();

    public static void main(String[] args) {
        String nome,cnpj, cpf, sobrenome, email, genero, senha="1";
        editora.setNome("Gusta_Books");
        editora.setCnpj("13.912.556/0001-04");

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
                "\n2- Cadastre-se" +
                "\n0- Encerrar");
        int opcao = tec.nextInt();
        switch (opcao){
            case 1:
                login();
                break;
            case 2:
                cadastro();
                break;
            case 0:
                System.exit(0);
                break;
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
                    user = listaPessoas.get(i);
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
        System.out.println("Cadastro realizado com sucesso!");
        menuInicial();
    }

    public static void menuPrincipal(){
        int opcao=0;
        if(listaPessoas.get(indicePessoa) instanceof Revisor){
            System.out.println("--- MENU PRINCIPAL ---" +
                    "\n1- Listar atividade" +
                    "\n2- Listar livros" +
                    "\n3- Editar livros" +
                    "\n4- Logout" +
                    "\n0- Encerrar");
            opcao = tec.nextInt();
            switch (opcao){
                case 1:
                    user.listarAtividade();
                    if(Revisor.cont > -1){
                        System.out.println("Deseja editar algum livro?");
                        char resp =  tec.next().charAt(0);
                        if(resp == 's' || resp == 'S'){
                            int indiceLivro = verificaLivro();
                            if(indiceLivro == -1){
                                System.out.println("Livro não encontrado!");
                                menuPrincipal();
                            }else{
                                listaLivros.get(indiceLivro).setStatus(2);
                                user.editarLivro();
                            }
                        }else if(resp == 'n' || resp == 'N'){
                            menuPrincipal();
                        }else{
                            System.out.println("ANTA DIGITA DIREITO!!");
                            menuPrincipal();
                        }
                    }else{
                        System.out.println("Nenhuma atividade para listar!");
                        menuPrincipal();
                    }
                    menuPrincipal();
                    break;
                case 4:
                    menuInicial();
                    break;
            }
        }else if(listaPessoas.get(indicePessoa) instanceof Autor){
            System.out.println("--- MENU PRINCIPAL ---" +
                    "\n1- Cadastrar livro" +
                    "\n2- Listar livros" +
                    "\n3- Editar livro" +
                    "\n4- Logout" +
                    "\n0- Encerrar");
            opcao = tec.nextInt();
            switch (opcao){
                case 1:
                    cadastrarLivro();
                    menuPrincipal();
                    break;
                case 3:
                    user.editarLivro();
                    menuPrincipal();
                    break;
                case 4:
                    menuInicial();
                    break;
            }
        }else if(listaPessoas.get(indicePessoa) instanceof Diretor){
            System.out.println("--- MENU PRINCIPAL ---" +
                    "\n1- Listar atividade" +
                    "\n2- Listar livros" +
                    "\n3- Editar livros" +
                    "\n4- Cadastrar revisor" +
                    "\n5- Logout" +
                    "\n0- Encerrar");
            opcao = tec.nextInt();
            switch (opcao){
                case 1:
                    user.listarAtividade();
                    if(Diretor.cont > -1){
                        System.out.println("Deseja editar algum livro?");
                        char resp =  tec.next().charAt(0);
                        if(resp == 's' || resp == 'S'){
                            int indiceLivro = verificaLivro();
                            if(indiceLivro == -1){
                                System.out.println("Livro não encontrado!");
                                menuPrincipal();
                            }else{
                                listaLivros.get(indiceLivro).setStatus(2);
                                user.editarLivro();
                            }
                        }else if(resp == 'n' || resp == 'N'){
                            menuPrincipal();
                        }else{
                            System.out.println("ANTA DIGITA DIREITO!!");
                            menuPrincipal();
                        }
                    }else{
                        System.out.println("Nenhuma atividade para listar!");
                        menuPrincipal();
                    }
                    menuPrincipal();
                    break;
                case 5:
                    menuInicial();
                    break;
            }
        }
        switch (opcao){
            case 2:
                user.listarLivros();
                if(user instanceof Revisor){
                    if(Revisor.cont > -1){
                        System.out.println("Deseja revisar algum livro listado?");
                        char resp =  tec.next().charAt(0);
                        if(resp == 's' || resp == 'S'){
                            int indiceLivro = verificaLivro();
                            if(indiceLivro == -1){
                                System.out.println("Livro não encontrado!");
                                menuPrincipal();
                            }else{
                                listaLivros.get(indiceLivro).setStatus(2);
                            }
                        }else if(resp == 'n' || resp == 'N'){
                            menuPrincipal();
                        }else{
                            System.out.println("ANTA DIGITA DIREITO!!");
                            menuPrincipal();
                        }
                    }else {
                        System.out.println("Nenhum livro para listar!");
                        menuPrincipal();
                    }
                }
                menuPrincipal();
                break;
            case 3:
                user.editarLivro();
                menuPrincipal();
                break;
            case 4:
                cadastrarRevisor();
                menuPrincipal();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public static void cadastrarLivro(){
        System.out.print("--- CADASTRO DE LIVROS ---" +
                "\nTítulo: ");
        String titulo = tec.next();
        System.out.print("Quantidade de páginas: ");
        int qtdPag = tec.nextInt();
        System.out.print("ISBN: ");
        int isbn = tec.nextInt();

        Livro livro = new Livro(titulo, (Autor) user ,1, qtdPag, isbn);
        listaLivros.add(livro);
    }

    public static void cadastrarRevisor(){
        System.out.print("Informe as informações a seguir: " +
                "\nNome do revisor: ");
        String nome = tec.next();
        System.out.print("Informe o sobrenome do revisor: ");
        String sobrenome = tec.next();
        System.out.print("Informe o CPF do revisor: ");
        String cpf = tec.next();
        System.out.print("Informe o gênero do revisor: ");
        String genero = tec.next();
        System.out.print("Informe o email do revisor: ");
        String email = tec.next();
        System.out.print("Informe a senha do revisor: ");
        String senha = tec.next();

        Revisor revisor = new Revisor(nome, cpf, sobrenome, email, genero, senha);
        listaPessoas.add(revisor);
    }

    public static int selecionaTipoEditar(String opcaoMenu, int indiceLivro){
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
            return opcao;
    }

    public static int verificaLivro(){
        System.out.print("Informe o ISBN do livro que você deseja editar: ");
        int isbn = tec.nextInt();
        int verifica = -1;
        for (int i=0;i<listaLivros.size();i++){
            if(listaLivros.get(i).getIsbn() == isbn) {
                return i;
            }
        }
        return verifica;
    }


}
