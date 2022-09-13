import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner tec = new Scanner(System.in);
    public static int indicePessoa;
    public static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    public static ArrayList<Livro> listaLivros = new ArrayList<>();
    public static Pessoa user;
    public static Editora editora = new Editora();

    public static void main(String[] args) throws Exception {
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

    public static void menuInicial() throws Exception{
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
                    cadastro();
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

    public static void login() throws Exception {
        try{
            int num = 0;
            System.out.print("Informe o seu nome: ");
            String nome = tec.next();
            for(int i=0; i< listaPessoas.size();i++){
                if(nome.equals(listaPessoas.get(i).getNome())){
                    System.out.print("Informe a senha: ");
                    String senha = tec.next();
                    if(listaPessoas.get(i).getSenha().equals(senha)){
                        indicePessoa = i;
                        user = listaPessoas.get(i);
                        num =0;
                        menuPrincipal();
                    }else{
                        throw new SenhaIncorretaException();
                    }
                }else {
                    num =1;
                }
            }
            if(num == 1){
                throw new UsuarioIncorretoException();
            }
        }catch (Exception erro) {
            System.out.println("Deu ruim\n"
                    + erro.getClass().getSimpleName() + ": "
                    + erro.getMessage());
            if (erro.getClass().getSimpleName().equals("SenhaIncorretaException") ||
                    erro.getClass().getSimpleName().equals("UsuarioIncorretoException")) {
                login();
            }
        }
    }

    public static void cadastro() throws Exception {
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

    public static void menuPrincipal() throws Exception {
        try{

            System.out.println("---- MENU PRINCIPAL ----");
            String[] opcoes = user.opcoes();
            for(String opcao2 : opcoes){
                System.out.println(opcao2);
            }
            int escolha = tec.nextInt();
            if(escolha == opcoes.length){
                System.exit(0);
            }else if(escolha == (opcoes.length - 1)){
                menuInicial();
            }else if(escolha < 1 || escolha > opcoes.length){
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
                            cadastrarRevisor();
                        }else {
                            cadastrarLivro();
                        }
                        menuPrincipal();
                        break;
                }
            }
        }catch (Exception erro) {
            System.out.println("Deu ruim\n"
                    + erro.getClass().getSimpleName() + ": "
                    + erro.getMessage());
            if (erro.getClass().getSimpleName().equals("LivroExistenteException") ||
                    erro.getClass().getSimpleName().equals("QtdPagInvalidaException") ||
                    erro.getClass().getSimpleName().equals("CodInvalidoException")) {
                cadastrarLivro();
            }else if(erro.getClass().getSimpleName().equals("OpcaoInvalidaException")){
                menuPrincipal();
            }
        }
    }

    public static void cadastrarLivro() throws Exception {
        System.out.print("--- CADASTRO DE LIVROS ---" +
                "\nTítulo: ");
        String titulo = tec.next();
        for(int i=0; i< listaLivros.size();i++){
            if(titulo.equals(listaLivros.get(i).getTitulo())){
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
        for(int i =0; i< listaLivros.size();i++){
            if(listaLivros.get(i).getIsbn().equals(isbn)){
                throw new LivroExistenteException();
            }
        }
        if(isbn.length() != 13){
            throw new CodInvalidoException();
        }
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
}