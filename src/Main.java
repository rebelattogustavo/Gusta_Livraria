import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner tec = new Scanner(System.in);
    private static int indicePessoa;
    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    private static ArrayList<Livro> listaLivros = new ArrayList<>();
    private static Pessoa user;
    static Editora editora = new Editora();

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
                "\n2- Cadastre-se");
        int opcao = tec.nextInt();
        switch (opcao){
            case 1:
                login();
                break;
            case 2:
                cadastro();
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

    private static void menuPrincipal(){
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
                    listarAtividade();
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
                    editarLivros();
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
                    listarAtividade();
                    menuPrincipal();
                    break;
                case 5:
                    menuInicial();
                    break;
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
        int cont= -1;
        if(listaPessoas.get(indicePessoa) instanceof Revisor){
            for(int i =0;i< listaLivros.size();i++){
                if(listaLivros.get(i).getStatus() == 2){
                    System.out.println(listaLivros.get(i).toString());
                    cont++;
                }
            }
            if(cont > -1){
                System.out.println("Deseja editar algum livro?");
                char resp =  tec.next().charAt(0);
                if(resp == 's' || resp == 'S'){
                    editarLivros();
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
        }else if(listaPessoas.get(indicePessoa) instanceof Diretor){
            cont= -1;
            for (int i =0;i<listaLivros.size();i++){
                if(listaLivros.get(i).getStatus() == 4){
                    System.out.println(listaLivros.get(i).toString());
                    cont++;
                }
            }
            if(cont > -1){
                System.out.println("Deseja editar algum livro?");
                char resp =  tec.next().charAt(0);
                if(resp == 's' || resp == 'S'){
                    editarLivros();
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
        }
    }

    private static void cadastrarLivro(){
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

    private static void listarLivros(){
        int cont =-1;
        if(listaPessoas.get(indicePessoa) instanceof Revisor){
            for(int i =0;i<listaLivros.size();i++){
                if(listaLivros.get(i).getStatus() == 1){
                    System.out.println(listaLivros.get(i).toString());
                    cont++;
                }
            }
            if(cont > -1){
                System.out.println("Deseja revisar algum livro listado?");
                char resp =  tec.next().charAt(0);
                if(resp == 's' || resp == 'S'){
                    System.out.print("Informe o ISBN do livro desejado: ");
                    int isbn = tec.nextInt();
                    for(int i =0;i<listaLivros.size();i++){
                        if(listaLivros.get(i).getIsbn() == isbn){
                            System.out.println("Livro adicionado a sua lista de atividade!");
                            listaLivros.get(i).setStatus(2);
                            menuPrincipal();
                        }
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
        } else if(listaPessoas.get(indicePessoa) instanceof Diretor){
            cont = -1;
            for(int i =0;i<listaLivros.size();i++){
                System.out.println(listaLivros.get(i).toString());
                cont++;
            }
            if (cont == -1) {
                System.out.println("Nenhum livro para listar!");
                menuPrincipal();
            }
        } else if(listaPessoas.get(indicePessoa) instanceof Autor){
            cont = -1;
            for (int i=0;i<listaLivros.size();i++){
                if(listaPessoas.get(indicePessoa) == listaLivros.get(i).getAutor()){
                    System.out.println(listaLivros.get(i).toString());
                    cont++;
                }
            }
            if (cont == -1){
                System.out.println("Você cadastrou nenhum livro até o momento!");
                menuPrincipal();
            }
        }
            menuPrincipal();
    }

    private static void editarLivros(){
        int cont =-1;
        System.out.print("Informe o ISBN do livro que você deseja editar: ");
        int isbn = tec.nextInt();
        for (int i=0;i<listaLivros.size();i++){
            if(listaLivros.get(i).getIsbn() == isbn){
                cont = 0;
                if (listaPessoas.get(indicePessoa) instanceof Revisor){
                    int opcaoEdita = selecionaTipoEditar("revisão");
                    switch (opcaoEdita){
                        case 1:
                            listaLivros.get(i).setStatus(4);
                            listaLivros.get(i).setPorcentagem(100);
                            break;
                        case 2:
                            listaLivros.get(i).setStatus(5);
                            break;
                        case 3:
                            listaLivros.get(i).setStatus(3);
                            System.out.print("Informe em qual página você parou a revisão: ");
                            int pagLidas = tec.nextInt();
                             listaLivros.get(i).mudarPorcent(listaLivros.get(i).getQtdPag(), pagLidas);
                             break;
                    }
                }else if(listaPessoas.get(indicePessoa) instanceof Diretor){
                    int opcaoEdita = selecionaTipoEditar("passagem pelo revisor");
                    switch (opcaoEdita){
                        case 1:
                            listaLivros.get(i).setStatus(4);
                            break;
                        case 2:
                            listaLivros.get(i).setStatus(5);
                            break;
                        case 3:
                            listaLivros.get(i).setStatus(6);
                            listaLivros.get(i).setEditora(editora);
                            break;
                    }
                }else if(listaPessoas.get(indicePessoa) instanceof Autor){
                    System.out.println("Terminou a edição?");
                    char resp = tec.next().charAt(0);
                    if(resp == 's' || resp == 'S'){
                        listaLivros.get(i).setStatus(1);
                    }else{
                        menuPrincipal();
                    }
                }
            }
        }
        if(cont == -1){
            System.out.println("Livro não encontrado ou inexistente!");
            menuPrincipal();
        }
        menuPrincipal();
    }

    private static void cadastrarRevisor(){
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

    public static int selecionaTipoEditar(String opcaoMenu){
        int opcao =0;
        if(listaPessoas.get(indicePessoa) instanceof Revisor){
            System.out.println("Informe o status do livro após a " + opcaoMenu +
                    "\n1- Aprovar" +
                    "\n2- Reprovar" +
                    "\n3- Solicitar edição");
            opcao = tec.nextInt();
        }else if(listaPessoas.get(indicePessoa) instanceof Diretor){
            System.out.println("Informe o status do livro após a " + opcaoMenu +
                    "\n1- Aprovar" +
                    "\n2- Reprovar" +
                    "\n3- Publicar");
            opcao = tec.nextInt();
        }
            return opcao;
    }

}
