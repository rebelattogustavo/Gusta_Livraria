public class Diretor extends Pessoa{
    @Override
    public void listarLivros() throws Exception {
        int cont = -1;
        for(int i =0;i<Main.listaLivros.size();i++){
            System.out.println(Main.listaLivros.get(i).toString());
            cont++;
        }
        if (cont == -1) {
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
        String livros = "";
        for (int i =0;i<Main.listaLivros.size();i++){
            if(Main.listaLivros.get(i).getStatus() == 4){
                livros += Main.listaLivros.get(i).toString();
            }
        }
        return livros;
    }


    public Diretor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
    }
}
